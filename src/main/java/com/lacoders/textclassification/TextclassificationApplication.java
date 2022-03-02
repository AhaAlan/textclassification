package com.lacoders.textclassification;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.lacoders.textclassification.dao")
@SpringBootApplication
public class TextclassificationApplication {
    public static void main(String[] args) {
        System.out.println("springboot 容器启动");
        SpringApplication.run(TextclassificationApplication.class, args);
        System.out.println("springboot 容器完成");
    }
}
