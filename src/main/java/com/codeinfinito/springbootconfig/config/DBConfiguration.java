package com.codeinfinito.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring-datasource")
@Getter
@Setter
public class DBConfiguration {
    
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnectionString() {
        System.out.println("DB Connection for DEV - H2");
        System.out.println(this.getDriverClassName());
        System.out.println(this.getUrl());
        return "DB Connection to H2_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnectionString() {
        System.out.println("DB Connection for PRODUCTION - MYSQL");
        System.out.println(this.getDriverClassName());
        System.out.println(this.getUrl());
        return "DB Connection to MYSQL_PROD - PRODUCTION instance";
    }
}
