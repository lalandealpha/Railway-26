package com.vti.entity.exceptionTest;
import java.time.LocalDate;

public class Exam {
	public short id;
	public String code;
	public String title;
	public Duration duration;
	public Teacher creator;
	public Question[] questions;
	public LocalDate createDate;
	
}
