package com.family.wqq.domain.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/29 16:01
 * @Version 1.0
 **/
@Table(name = "sys_user")
@Data
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String avatar;
    private Boolean delFlag;
    @ApiModelProperty("用户状态,0正常 1 已禁用")
    private Short status;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    private String lastLoginIp;
}
