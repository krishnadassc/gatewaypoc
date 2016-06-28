package com.cisco.it.sig.spark.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.cisco.it.sig.spark.contract.IMongoBaseDao;
import com.cisco.it.sig.spark.entity.MGPayload;
import com.cisco.it.sig.spark.entity.SparkEntity;

@Service
public class SparkDaoImpl implements IMongoBaseDao{

	@Autowired
	private MongoTemplate mongotemplate;
	@Override
	public void create(SparkEntity entity) {
		mongotemplate.save(entity);
		
	}

	@Override
	public void save(SparkEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(String id) {
		// TODO Auto-generated method stub
		
	}

	
}
