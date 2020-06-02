package com.waterkemper.springsecurityjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@SpringBootApplication
@EntityScan("com.waterkemper")
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }
}
