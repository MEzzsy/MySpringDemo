package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//开启组件扫描和自动配置
@ComponentScan(basePackages = "com.example.demo.controller")//用于扫描@Controller @Service
@EnableJpaRepositories(basePackages = "com.example.demo.dao")//用于扫描Dao @Repository
@EntityScan(basePackages = "com.example.demo.entity")//用于扫描JPA实体类 @Entity
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);//负责启动引导应用程序
    }

}
