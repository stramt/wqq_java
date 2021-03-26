package com.family.wqq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.family.wqq.mapper")
public class WqqApplication {

    public static void main(String[] args) {
        SpringApplication.run(WqqApplication.class, args);
    }

}
