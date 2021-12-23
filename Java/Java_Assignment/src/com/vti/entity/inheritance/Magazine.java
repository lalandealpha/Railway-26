package com.vti.entity.inheritance;

public class Magazine extends Document {
	int publishId;
	int publishMonth;

	public Magazine(int id, String publisher, int numberOfCopy, int publishId, int publishMonth) {
		super(id, publisher, numberOfCopy);
		this.publishId = publishId;
		this.publishMonth = publishMonth;
	}
	
	public int getPublishId() {
		return publishId;
	}
	
	public int getPublishMonth() {
		return publishMonth;
	}
	
	public void setPublishId(int publishId) {
		this.publishId = publishId;
	}
	
	public void setPublishMonth(int publishMonth) {
		this.publishMonth = publishMonth;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nPublish ID: " + publishId + "\nPublished Month: " + publishMonth;
	}
}
