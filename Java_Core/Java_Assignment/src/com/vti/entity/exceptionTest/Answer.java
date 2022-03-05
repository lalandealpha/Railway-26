package com.vti.entity.exceptionTest;

public class Answer {
	public int id;
	public String content;
	public Question question;
	public boolean isCorrect;

	@Override
	public String toString() {
		return "Answer [id: " + id + ", content: " + content + ", true or false: " + isCorrect + "]";
	}
}