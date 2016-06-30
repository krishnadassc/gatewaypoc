package com.cisco.it.sig.spark.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ashsunda
 * SparkTransaction is used to store all transaction data. Any in coming message to spark should be persisted
 * to track the response from spark and send back to source machine
 */
@Document(collection="SPARK_TRANSACTION")
public class SparkTransaction implements SparkEntity{

	private String transactionId;
	private String roomId;
	
	/**
	 * TODO: Will check on this field later. Is is required to store this in DB
	 */
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
