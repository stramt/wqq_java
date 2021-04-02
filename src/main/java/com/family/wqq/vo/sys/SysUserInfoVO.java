package com.family.wqq.vo.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SysUserInfoVO
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/4/1 13:49
 * @Version 1.0
 **/
@Data
public class SysUserInfoVO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String avatar;
    private Short status;
    private String telephone;
    private String lastLoginIp;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastLoginTime;
    private String creatorId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private Integer deleted;
    private String roleId;
    private String lang;
    private String token;
    private Map<String,Object> role;
}
