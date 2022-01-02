package com.vti.entity;

import java.time.LocalDate;

public class Question {
	public short id;
	public String content;
	public QuestionCategory category;
	public QuestionType type;
	public Teacher creator;
	public LocalDate createDate;
	public Exam[] usedInExams;
	public Answer[] answers;

	@Override
	public String toString() {

		StringBuffer output = new StringBuffer();
		output.append("Question: ");
		output.append(id);
		for (Answer a : answers) {
			output.append(" Answer: ");
			output.append(a.content);
		}
		return output.toString();
	}

}
