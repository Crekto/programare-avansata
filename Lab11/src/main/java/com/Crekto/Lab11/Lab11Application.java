package com.Crekto.Lab11;

import com.Crekto.Lab11.dao.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class Lab11Application {

    public static void main(String[] args) {
        Database.createConnection();
        SpringApplication.run(Lab11Application.class, args);
    }

}
