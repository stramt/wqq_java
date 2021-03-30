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
    public PageResult<UserPageVO> getUserPage(Integer pageNum, Integer pageSize) {

        Example e = new Example(SysUser.class);
        e.createCriteria().andEqualTo("delFlag", false);
        PageHelper.startPage(pageNum, pageSize);
       Page<SysUser> data = (Page<SysUser>) this.userMapper.selectAll();
        List<UserPageVO> list = ObjectTypeTransUtil.entityListToModelList(data.getResult(), UserPageVO.class);
        PageResult<UserPageVO> result = new PageResult<>();
        result.setTotalPage(data.getPages());
        result.setTotal(data.getTotal());
        result.setItems(list);
        return result;
    }

}
