package com.spring.mongo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringBootMongoDbCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoDbCrudApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.spring.mongo.api"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Spring Boot MongoDB CRUD Restful APIs",
                "Sample API for Spring BOOT CRUD Operation using MongoDB",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Ajay Dhami", "http://ajay.np", "abc@gmail.com"),
                "API License",
                "http://ajay.com.np",
                Collections.emptyList());
    }

}
