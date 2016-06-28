package com.cisco.it.sig.spark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cisco.it.sig.spark.client.SparlkClient;
import com.cisco.it.sig.spark.contract.ISparkService;
import com.cisco.it.sig.spark.dao.SparkDaoImpl;
import com.cisco.it.sig.spark.entity.MGPayload;
import com.cisco.it.sig.spark.entity.SparkRoomInfo;
import com.ciscospark.Message;
import com.ciscospark.Room;


@Service
public class SparkServiceImpl implements ISparkService{
	private SparlkClient sparkClient = new SparlkClient();
	@Autowired
	private SparkDaoImpl sparkDao;
	@Override
	public void sendMessage( MGPayload mgPayload) {
		SparkRoomInfo sparkRoomInfo = getRoomInfo(mgPayload.getUserId(), mgPayload.getAppId());
		if(sparkRoomInfo == null){
			Room room = sparkClient.createroom(mgPayload.getAppId()+"-"+mgPayload.getUserId());
			sparkClient.addmember(room, mgPayload.getUserId());
			sparkRoomInfo = new SparkRoomInfo();
			sparkRoomInfo.setAppId(mgPayload.getAppId());
			sparkRoomInfo.setUserId(mgPayload.getUserId());
			sparkRoomInfo.setRoomId(room.getId());
			sparkDao.create(sparkRoomInfo);
		}
		Message message = new Message();
	    message.setRoomId(sparkRoomInfo.getRoomId());
	    message.setText(mgPayload.getMessage());
		sparkClient.sendMessage(message);
		
	}
	

	private SparkRoomInfo getRoomInfo(String userid, String appId){
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userid).andOperator(Criteria.where("appId").is(appId)));
		SparkRoomInfo sparkRoomInfo = (SparkRoomInfo) sparkDao.findByQuery(query, SparkRoomInfo.class, "SPARK_ROOM_INFO");
		return sparkRoomInfo;
	}

}
