package com.vti.entity.inheritance;

public class Book extends Document {
	String author;
	int numberOfPage;

	public Book(int id, String publisher, int numberOfCopy, String author, int numberOfPage) {
		super(id, publisher, numberOfCopy);
		this.author = author;
		this.numberOfPage = numberOfPage;
	}

	public String getAuthor() {
		return author;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	@Override
	public String toString() {
		return super.toString() + "\nAuthor: " + author + "\nNumber of Pages: " + numberOfPage;
	}
}
