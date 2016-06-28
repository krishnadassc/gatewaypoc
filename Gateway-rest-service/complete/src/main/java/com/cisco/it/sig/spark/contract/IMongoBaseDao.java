package com.cisco.it.sig.spark.contract;

import com.cisco.it.sig.spark.entity.SparkEntity;

public interface IMongoBaseDao {

	public void create(SparkEntity entity);
	
	public void save(SparkEntity entity);
	
	public void delete(String id);
	
	public void find(String id);
}
