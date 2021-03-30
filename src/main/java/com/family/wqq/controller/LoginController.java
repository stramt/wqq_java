package com.family.wqq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/29 15:18
 * @Version 1.0
 **/
@RestController
public class LoginController {
    @GetMapping("/api/login")
    public String login(@RequestParam String username,@RequestParam String password){
        if(username.equals("admin") && password.equals("123456")){
            return "success";
        }
        return "failed";
    }

}
