package com.cisco.it.sig.spark.entity;

/**
 * @author krchella
 * This is a mongo entity class to store SPARK_ROOM_INFO documents
 */
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SPARK_ROOM_INFO")
public class SparkRoomInfo implements SparkEntity{

	private String roomId;
	private String appId;
	private String userId;
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String tenantId) {
		this.userId = tenantId;
	}
}
