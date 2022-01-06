package com.atguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.atguigu.admin.mapper")                 //自动扫描mapper文件目录
@ServletComponentScan(basePackages = "com.atguigu.admin")            //扫描servlet所在的文件
@SpringBootApplication                                  //springboot主程序所需注解
public class Spring03BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring03BootApplication.class, args);
    }

}
