package com.southwind.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringboottestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringboottestApplication.class);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringboottestApplication.class, args);
        System.out.println("Running............");
    }
}
