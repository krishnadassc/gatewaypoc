package com.cisco.it.sig.spark.contract;

import org.springframework.data.mongodb.core.query.Query;

import com.cisco.it.sig.spark.entity.SparkEntity;

public interface IMongoBaseDao {

	public void create(SparkEntity entity);
	
	public void save(SparkEntity entity);
	
	public void delete(String id);
	
	public void find(String id);
	
	public Object findByQuery(Query query, Class entityClass, String entityCollection);
	
}
