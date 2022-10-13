package com.reto3_final.reto3_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EntityScan(basePackages = {"com.reto3_final.reto3_final"})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Reto3FinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(Reto3FinalApplication.class, args);
    }

}
