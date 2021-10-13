package com.example.blog.ortak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import java.time.LocalDate;

public class Swagger {

    @EnableSwagger2
    @Configuration
    public class SwaggerConfig {
        ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("Demo BE Projesi API Dökümantasyonu")
                    .version("1.0.0")
                    .build();
        }

        public Docket customImplementation() {
            return new Docket(DocumentationType.OAS_30)
           // return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select().paths(PathSelectors.any())
                    .apis(RequestHandlerSelectors.basePackage("com.example.blog"))
                    .build()
                    .pathMapping("/")
                    .useDefaultResponseMessages(false)
                    .directModelSubstitute(LocalDate.class, String.class)
                    .genericModelSubstitutes(ResponseEntity.class)// Butunresponselarımızboyle olacak !!!
                    ;
        }
    }


    }

