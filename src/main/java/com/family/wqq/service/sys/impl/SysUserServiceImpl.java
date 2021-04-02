package com.family.wqq.service.sys.impl;

import cn.hutool.core.date.DateUtil;
import com.family.wqq.common.rsp.PageResult;
import com.family.wqq.common.rsp.ResultCode;
import com.family.wqq.domain.sys.SysUser;
import com.family.wqq.dto.sys.AddOrUpdateUserDTO;
import com.family.wqq.exception.RRException;
import com.family.wqq.mapper.sys.SysUserMapper;
import com.family.wqq.service.sys.SysUserService;
import com.family.wqq.utils.Md5Utils;
import com.family.wqq.utils.ObjectTypeTransUtil;
import com.family.wqq.vo.sys.UserPageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/29 16:10
 * @Version 1.0
 **/
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(AddOrUpdateUserDTO dto) {
        //校验账号是否存在
        Example e = new Example(SysUser.class);
        e.createCriteria().andEqualTo("account", dto.getAccount()).andEqualTo("delFlag", false);
        int userExistCount = this.userMapper.selectCountByExample(e);
        if (userExistCount > 0) {
            throw new RRException("当前账号已存在", ResultCode.FAIL.code());
        }
        String salt = RandomStringUtils.randomAlphanumeric(20);
        String dbPassword = Md5Utils.sha256(dto.getPassword(), salt);
        SysUser user = ObjectTypeTransUtil.entityToModel(dto, SysUser.class);
        user.setSalt(salt);
        user.setPassword(dbPassword);
        user.setDelFlag(false);
        user.setStatus((short) 0);
        user.setCreateTime(DateUtil.date().toJdkDate());
        return this.userMapper.insertSelective(user);
    }

    @Override
    public PageResult<UserPageVO> getUserPage(Integer pageNum, Integer pageSize,String account,String sortField,String sortOrder,Short status) {

        Example e = new Example(SysUser.class);
        Example.Criteria criteria = e.createCriteria();
        if(StringUtils.isNotBlank(sortField)){
            if("ascend".equals(sortOrder)){
                e.setOrderByClause("create_time asc");
            }else {
                e.setOrderByClause("create_time desc");
            }
        }else {
            e.setOrderByClause("create_time desc");
        }
        criteria.andEqualTo("delFlag", false);
        if(StringUtils.isNotBlank(account)){
            criteria.andLike("account","%"+account+"%");
        }
        if(status!=null){
            criteria.andEqualTo("status",status);
        }
        PageHelper.startPage(pageNum, pageSize);
       Page<SysUser> data = (Page<SysUser>) this.userMapper.selectByExample(e);
        List<UserPageVO> list = ObjectTypeTransUtil.entityListToModelList(data.getResult(), UserPageVO.class);
        PageResult<UserPageVO> result = new PageResult<>();
        result.setTotalPage(data.getPages());
        result.setTotal(data.getTotal());
        result.setPageSize(pageSize);
        result.setCurrentPage(pageNum);
        result.setItems(list);
        return result;
    }

    @Override
    public int updateUser(AddOrUpdateUserDTO dto) {
        SysUser sysUser = this.userMapper.selectByPrimaryKey(dto.getId());
        if(sysUser==null || sysUser.getDelFlag()){
            throw new RRException("当前用户不存在",ResultCode.FAIL.code());
        }
        SysUser userData = ObjectTypeTransUtil.entityToModel(dto, SysUser.class);
        String dbPassword = Md5Utils.sha256(dto.getPassword(), sysUser.getSalt());
        userData.setPassword(dbPassword);
        return this.userMapper.updateByPrimaryKeySelective(userData);
    }

    @Override
    public int batchDelUser(List<Long> ids) {
        for(Long id:ids){
            SysUser sysUser = this.userMapper.selectByPrimaryKey(id);
            sysUser.setDelFlag(true);
            this.userMapper.updateByPrimaryKeySelective(sysUser);
        }
        return 1;
    }

}
