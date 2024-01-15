package com.mapletan.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.mapletan.demo", "com.alibaba.cola"})
@Configurable
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
