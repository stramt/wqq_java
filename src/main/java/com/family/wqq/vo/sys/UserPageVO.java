package com.family.wqq.vo.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserPageVO
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/29 16:40
 * @Version 1.0
 **/
@ApiModel("用户列表vo")
@Data
public class UserPageVO {
    private Long id;
    private String account;
    private String username;
    private String phone;
    private String headImage;
    @ApiModelProperty("用户状态,0正常 1 已禁用")
    private Short status;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
