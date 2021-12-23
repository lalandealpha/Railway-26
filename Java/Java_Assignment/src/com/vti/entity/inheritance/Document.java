package com.vti.entity.inheritance;

public abstract class Document {
	protected int id;
	protected String publisher;
	protected int numberOfCopy;
	
	public Document(int id, String publisher, int numberOfCopy) {
		this.id = id;
		this.publisher = publisher;
		this.numberOfCopy = numberOfCopy;
	}
	
	public int getId() {
		return id;
	}
	
	public String getPublishser() {
		return publisher;
	}
	
	public int getNumberOfCopy() {
		return numberOfCopy;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setNumberOfCopy(int numberOfCopy) {
		this.numberOfCopy = numberOfCopy;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + "\nPublisher: " + publisher + "\nNumber of copies: " + numberOfCopy;
	}
}























