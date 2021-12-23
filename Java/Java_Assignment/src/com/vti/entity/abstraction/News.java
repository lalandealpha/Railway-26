package com.vti.entity.abstraction;

public class News implements INews {
	private static int count;
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getPublishDate() {
		return publishDate;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getContent() {
		return content;
	}
	
	public float getAverageRate() {
		return averageRate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void display() {
		System.out.println("Title: " + title + "\nPublish Date: " + publishDate +
				"\nAuthor: " + author + "\nContent: " + content + "\nAverage Rate:" + averageRate);	
	}

	@Override
	public float calculate(int rate1, int rate2, int rate3) {
		float averageRate = (rate1 + rate2 + rate3) / (float) 3;
		return averageRate;
	}
	
	

	
	public News(String title, String publishDate, String author, String content) {
		this.id = ++count;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;

	}
	
}
