package com.cisco.it.sig.spark.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.it.sig.spark.contract.ISparkService;
import com.cisco.it.sig.spark.entity.MGPayload;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ashsunda
 * SparkController contains all the rest endpoints to communicate for the outside systems
 */
@RestController
public class SparkController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private ISparkService sparkService;
    @Autowired
    private MongoTemplate mongoTemplate;
    
    /**
     * This endpoint is the used to accept all the incoming message for spark
     * TODO: Add example payload with URL once the payload is finalized
     * @param payload
     * @return
     */
    @RequestMapping("/message")
    public String message(@RequestBody  String payload) {
    	System.out.println("payload:"+payload);
    	ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    	MGPayload mgPayload = null;
		try {
			mgPayload = mapper.readValue(payload, MGPayload.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	sparkService.sendMessage(mgPayload);
    	System.out.println("DB:!!!!!!!!!!!!!!!!!!!!!!!!"+mongoTemplate.getDb());
        return "hi Hello";
    }
}
