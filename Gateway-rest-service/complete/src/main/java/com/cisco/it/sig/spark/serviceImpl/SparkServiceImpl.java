package com.cisco.it.sig.spark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.cisco.it.sig.spark.contract.ISparkService;
import com.cisco.it.sig.spark.dao.SparkDaoImpl;
import com.cisco.it.sig.spark.entity.MGPayload;
import com.cisco.it.sig.spark.entity.SparkRoomInfo;


@Service
public class SparkServiceImpl implements ISparkService{

	@Autowired
	private SparkDaoImpl sparkDao;
	@Override
	public void sendMessage( MGPayload mgPayload) {
		if(!isRoomExist(mgPayload.getUserId(), mgPayload.getAppId())){
			SparkRoomInfo sparkRoomInfo = new SparkRoomInfo();
			sparkRoomInfo.setAppId(mgPayload.getAppId());
			sparkRoomInfo.setUserId(mgPayload.getUserId());
			sparkDao.create(sparkRoomInfo);
		}
	}
	
	private boolean isRoomExist(String userid, String appId){
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userid).andOperator(Criteria.where("appId").is(appId)));
		long count = sparkDao.findByQuery(query, SparkRoomInfo.class, "SPARK_ROOM_INFO");
		return count>0;
	}

}
