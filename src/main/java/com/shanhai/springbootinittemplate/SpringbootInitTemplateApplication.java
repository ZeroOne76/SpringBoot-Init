package com.shanhai.springbootinittemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootInitTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootInitTemplateApplication.class, args);
    }

}
