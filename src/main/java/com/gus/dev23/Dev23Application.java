package com.gus.dev23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Dev23Application {

    public static void main(String[] args) {
        SpringApplication.run(Dev23Application.class, args);
    }
}
