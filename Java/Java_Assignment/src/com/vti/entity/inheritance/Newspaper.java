package com.vti.entity.inheritance;

public class Newspaper extends Document {
	int publishDate;

	public Newspaper(int id, String publisher, int numberOfCopy, int publishDate) {
		super(id, publisher, numberOfCopy);
		this.publishDate = publishDate;
	}
	
	public int getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(int publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return super.toString() + "\nPublished Date: " + publishDate;
	}
}
