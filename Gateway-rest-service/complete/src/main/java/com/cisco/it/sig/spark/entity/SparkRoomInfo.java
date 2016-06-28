package com.cisco.it.sig.spark.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SPARK_ROOM_INFO")
public class SparkRoomInfo implements SparkEntity{

	private String roomId;
	private String appId;
	private String tenantId;
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
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}
