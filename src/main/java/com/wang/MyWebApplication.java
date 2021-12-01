package com.wang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication

public class MyWebApplication {
/*    @Value("${filepath.uploadFolder}")
    private String uploadFolder;*/
    public static void main(String[] args) {
        SpringApplication.run(MyWebApplication.class, args);
    }

  /*  @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(uploadFolder);
        return factory.createMultipartConfig();
    }*/
}
