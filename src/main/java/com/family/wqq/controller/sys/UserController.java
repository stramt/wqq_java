package com.family.wqq.controller.sys;

import com.family.wqq.common.rsp.PageResult;
import com.family.wqq.common.rsp.Result;
import com.family.wqq.common.rsp.ResultCode;
import com.family.wqq.dto.sys.AddOrUpdateUserDTO;
import com.family.wqq.exception.RRException;
import com.family.wqq.service.sys.SysUserService;
import com.family.wqq.vo.sys.MenuVO;
import com.family.wqq.vo.sys.Meta;
import com.family.wqq.vo.sys.UserPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @ApiOperation("修改用户信息")
    @PostMapping("/updateUser")
    public Result updateUserInfo(@RequestBody AddOrUpdateUserDTO dto){
        try {
            if(dto == null){
                return new Result(ResultCode.PARAM_IS_EMPTY);
            }
            userService.updateUser(dto);
            return Result.SUCCESS();
        }catch (RRException e){
            e.printStackTrace();
            return new Result(e.getCode(),e.getMessage(),false);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(ResultCode.SERVER_ERROR.code(),"修改用户失败",false);
        }
    }
    @ApiOperation("批量删除用户")
    @PostMapping("/batchDelUser")
    public Result batchDelUserInfo(@RequestBody List<Long> ids){
        try {
            userService.batchDelUser(ids);
            return Result.SUCCESS();
        }catch (RRException e){
            e.printStackTrace();
            return new Result(e.getCode(),e.getMessage(),false);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(ResultCode.SERVER_ERROR.code(),"修改用户失败",false);
        }
    }
    @ApiOperation("用户列表分页")
    @GetMapping("/getUserPage")
    public Result<PageResult<UserPageVO>> getUserPage(@RequestParam(required = false) Integer pageNo,@RequestParam Integer pageSize,
                                                      @RequestParam(required = false)String account,@RequestParam(required = false)String sortField,
                                                      @RequestParam(required = false)String sortOrder,@RequestParam(required = false)Short status){
        try {
            if(pageNo == null || pageNo<=1){
                pageNo=1;
            }
            PageResult<UserPageVO> data = userService.getUserPage(pageNo,pageSize,account,sortField,sortOrder,status);
            return new Result<>(ResultCode.SUCCESS,data);
        }catch (RRException e){
            e.printStackTrace();
            return new Result(e.getCode(),e.getMessage(),false);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(ResultCode.SERVER_ERROR.code(),"查询用户列表失败",false);
        }
    }
    @ApiOperation("获取菜单")
    @GetMapping("/getMenu")
    public Result<List<MenuVO>> getMenu(){
        List<MenuVO> list = new ArrayList<>();
        Meta m1 = Meta.builder().icon("dashboard").title("仪表盘").show(true).build();
        MenuVO v1 = MenuVO.builder().name("dashboard").parentId(0L).id(1L).component("RouteView").redirect("/dashboard/analysis").meta(m1).build();
        Meta m2 = Meta.builder().title("分析页").show(true).build();
        MenuVO v2 = MenuVO.builder().name("Analysis").parentId(1L).id(2L).meta(m2).component("Analysis").path("/dashboard/analysis").build();
        Meta m3 = Meta.builder().icon("table").title("用户管理").show(true).build();
        MenuVO v3 = MenuVO.builder().name("sys").parentId(0L).id(3L).redirect("/sys/user").component("PageView").meta(m3).build();
        list.add(v3);
        list.add(v2);
        list.add(v1);
        return new Result<>(ResultCode.SUCCESS,list);
    }
}
