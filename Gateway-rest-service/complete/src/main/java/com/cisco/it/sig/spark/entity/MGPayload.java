package com.cisco.it.sig.spark.entity;

import java.io.Serializable;

public class MGPayload implements Serializable{

	private static final long serialVersionUID = 1L;
	private String messageId;
	private String subject;
	private String message;
	private String userId;
	private String appId;
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
