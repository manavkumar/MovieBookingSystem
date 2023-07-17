package com.theatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class TheatreApp {
    public static void main(String[] args) {
        SpringApplication.run(TheatreApp.class, args);
    }
}
