package com.family.wqq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DashboardController
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/26 10:26
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @GetMapping("/getChart")
    public String getStr(@RequestParam Long id){
        if(id == 12345){
            return "[10,20,30,40,50,60]";
        }
        return "[60,50,40,30,20,10]";

    }
}
