package com.my.shrio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.my.shrio.dao")
@EnableCaching
public class MyshiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshiroApplication.class, args);
    }

}
