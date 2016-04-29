package com.qq.common;

public class Massage implements java.io.Serializable{
	private String massageType;
	private String sender;
	private String getter;
	private String sendTime;
	private String news;
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	

	public String getMassageType() {
		return massageType;
	}

	public void setMassageType(String massageType) {
		this.massageType = massageType;
	}


}
