package com.cisco.it.sig.spark.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SPARK_TRANSACTION")
public class SparkTransaction implements SparkEntity{

	private String transactionId;
	private String roomId;
	private String message;
	private String subject;
	private String sender;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
}
