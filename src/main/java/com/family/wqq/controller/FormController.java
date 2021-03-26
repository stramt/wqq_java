package com.family.wqq.controller;

import com.alibaba.fastjson.JSON;
import com.family.wqq.dto.FormDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FormController
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/26 14:58
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/form")
public class FormController {
    @PostMapping("/add")
    public String addForm(@RequestBody FormDTO dto){
        System.out.println("接收到form 请求");
        return JSON.toJSONString(dto);
    }
}
