package com.family.wqq.service.sys;

import com.family.wqq.common.rsp.PageResult;
import com.family.wqq.dto.sys.AddOrUpdateUserDTO;
import com.family.wqq.vo.sys.UserPageVO;

import java.util.List;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/29 16:09
 * @Version 1.0
 **/
public interface SysUserService {
    int addUser(AddOrUpdateUserDTO dto);

    PageResult<UserPageVO> getUserPage(Integer pageNum, Integer pageSize,String account,String sortField,String sortOrder,Short status);

    int updateUser(AddOrUpdateUserDTO dto);

    int batchDelUser(List<Long> ids);
}
