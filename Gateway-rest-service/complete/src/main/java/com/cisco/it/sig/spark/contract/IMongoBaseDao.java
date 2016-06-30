package com.cisco.it.sig.spark.contract;

import org.springframework.data.mongodb.core.query.Query;

import com.cisco.it.sig.spark.entity.SparkEntity;

/**
 * Base inteface for all MongoDb operation
 * @author krchella
 *
 */
public interface IMongoBaseDao {

	/**
	 * To save mongo document
	 * @param entity
	 * 
	 */
	public void create(SparkEntity entity);
	
	public void save(SparkEntity entity);
	
	public void delete(String id);
	
	public void find(String id);
	
	/**
	 * To find mongo document based on query
	 * @param query
	 * @param entityClass
	 * @param entityCollection
	 * @return
	 */
	public Object findByQuery(Query query, Class entityClass, String entityCollection);
	
}
