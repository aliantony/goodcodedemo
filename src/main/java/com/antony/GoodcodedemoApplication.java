package com.antony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//开启CGLIB代理
@EnableAspectJAutoProxy(exposeProxy = true)
public class GoodcodedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodcodedemoApplication.class, args);
    }

}
