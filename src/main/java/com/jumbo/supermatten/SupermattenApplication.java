package com.jumbo.supermatten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SupermattenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermattenApplication.class, args);
    }

}
