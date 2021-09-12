package com.ly.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.ly.study.elastic")
public class FrameworkStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkStudyApplication.class, args);
    }

}
