package com.cisco.it.sig.spark.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cisco.it.sig.spark.contract.IMongoBaseDao;
import com.cisco.it.sig.spark.entity.MGPayload;
import com.cisco.it.sig.spark.entity.SparkEntity;

/**
 * Contains all implementation methods to do CRUD on Spark message in MongoDB
 * @author krchella
 *
 */
@Service
public class SparkDaoImpl implements IMongoBaseDao{

	@Autowired
	private MongoTemplate mongotemplate;
	/* 
	 * (non-Javadoc)
	 * @see com.cisco.it.sig.spark.contract.IMongoBaseDao#create(com.cisco.it.sig.spark.entity.SparkEntity)
	 */
	@Override
	public void create(SparkEntity entity) {
		mongotemplate.save(entity);
		
	}

	@Override
	public void save(SparkEntity entity) {
		
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(String id) {
		// TODO Auto-generated method stub
		
	}
	
	/* 
	 * To find mongo document based on Query 
	 * (non-Javadoc)
	 * @see com.cisco.it.sig.spark.contract.IMongoBaseDao#findByQuery(org.springframework.data.mongodb.core.query.Query, java.lang.Class, java.lang.String)
	 */
	@Override
	public Object findByQuery(Query query, Class entityClass, String entityCollection){

		Object docCount = mongotemplate.findOne(query, entityClass, entityCollection);
		return docCount;
	}

	
}
