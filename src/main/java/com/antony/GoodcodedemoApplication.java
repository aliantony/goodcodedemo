package com.antony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GoodcodedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodcodedemoApplication.class, args);
    }

}
