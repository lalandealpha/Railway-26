package com.vti.entity.abstraction;

public class News implements INews {
	private static int count;
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private int rate1;
	private int rate2;
	private int rate3;

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

	public int getRate1() {
		return rate1;
	}

	public void setRate1(int rate1) {
		this.rate1 = rate1;
	}

	public int getRate2() {
		return rate2;
	}

	public void setRate2(int rate2) {
		this.rate2 = rate2;
	}

	public int getRate3() {
		return rate3;
	}

	public void setRate3(int rate3) {
		this.rate3 = rate3;
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
		System.out.println("Title: " + title + "\nPublish Date: " + publishDate + "\nAuthor: " + author + "\nContent: "
				+ content + "\nAverage Rate:" + calculateRates());
	}

	@Override
	public float calculateRates() {
		float averageRate = (rate1 + rate2 + rate3) / (float) 3;
		return averageRate;
	}

	public News(String title, String publishDate, String author, String content, int rate1, int rate2, int rate3) {
		this.id = ++count;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.rate1 = rate1;
		this.rate2 = rate2;
		this.rate3 = rate3;
	}
	
	public News(String title, String publishDate, String author, String content) {
		this.id = ++count;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
	}
}
