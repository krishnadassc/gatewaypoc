package com.cisco.it.sig.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com")
public class Application {

	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
		
		MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"),"spark");
		return mongoTemplate;
		
	}
}
