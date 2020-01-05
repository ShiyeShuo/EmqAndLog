package com.ls.emqtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ls.emqtest.client"})
public class EmqtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmqtestApplication.class, args);
    }

}
