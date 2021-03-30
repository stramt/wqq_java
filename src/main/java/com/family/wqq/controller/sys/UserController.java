package com.family.wqq.controller.sys;

import com.family.wqq.common.rsp.PageResult;
import com.family.wqq.common.rsp.Result;
import com.family.wqq.common.rsp.ResultCode;
import com.family.wqq.dto.sys.AddOrUpdateUserDTO;
import com.family.wqq.exception.RRException;
import com.family.wqq.service.sys.SysUserService;
import com.family.wqq.vo.sys.UserPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/29 16:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/user")
@Api(value = "系统管理员",description = "系统管理员")
public class UserController {
    @Autowired
    SysUserService userService;
    @ApiOperation("新增用户信息")
    @PostMapping("/addUser")
    public Result addUserInfo(@RequestBody AddOrUpdateUserDTO dto){
        try {
            if(dto == null){
                return new Result(ResultCode.PARAM_IS_EMPTY);
            }
            userService.addUser(dto);
            return Result.SUCCESS();
        }catch (RRException e){
            e.printStackTrace();
            return new Result(e.getCode(),e.getMessage(),false);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(ResultCode.SERVER_ERROR.code(),"新增用户失败",false);
        }
    }
    @ApiOperation("用户列表分页")
    @GetMapping("/getUserPage")
    public Result<PageResult<UserPageVO>> getUserPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        try {
            PageResult<UserPageVO> data = userService.getUserPage(pageNum,pageSize);
            return new Result<>(ResultCode.SUCCESS,data);
        }catch (RRException e){
            e.printStackTrace();
            return new Result(e.getCode(),e.getMessage(),false);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(ResultCode.SERVER_ERROR.code(),"查询用户列表失败",false);
        }
    }
}
