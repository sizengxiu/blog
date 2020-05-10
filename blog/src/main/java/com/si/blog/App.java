package com.si.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Hello world!
 *
 */
@MapperScan("com.si.blog.mapper")
@SpringBootApplication

public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        System.out.println("Hello World!");
        System.out.println(1);
    }
}

