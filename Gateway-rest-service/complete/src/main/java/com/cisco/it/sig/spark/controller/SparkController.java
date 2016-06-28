package com.cisco.it.sig.spark.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SparkController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
/*    @Autowired
    private ISparkService sparkService;
*/    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping("/message")
    public String message(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	System.out.println("DB:!!!!!!!!!!!!!!!!!!!!!!!!"+mongoTemplate.getDb());
        return "hi Hello";
    }
}
