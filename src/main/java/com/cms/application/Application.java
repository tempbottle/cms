package com.cms.application;

/**
 * Created by rkonell on 12/6/14.
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan
@EnableAutoConfiguration
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
