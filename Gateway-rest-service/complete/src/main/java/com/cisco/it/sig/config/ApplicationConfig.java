package com.cisco.it.sig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
@Configuration
@ComponentScan
public class ApplicationConfig {

	  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		  MongoClient mongoClient = new MongoClient("127.0.0.1");
		    return new SimpleMongoDbFactory(mongoClient, "spark");
		  }

		  public @Bean MongoTemplate mongoTemplate() throws Exception {
		    return new MongoTemplate(mongoDbFactory());
		  }
		  }
