package com.family.wqq.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName AddUserDTO
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/29 16:11
 * @Version 1.0
 **/
@ApiModel("新增修改用户dto")
@Data
public class AddOrUpdateUserDTO {
    private Long id;
    @ApiModelProperty("登录账号")
    private String account;
    @ApiModelProperty("姓名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("手机号")
    private String phone;
    private String headImage;
    private Short status;

}
