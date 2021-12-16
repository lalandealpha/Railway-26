package com.vti.entity;
import java.time.LocalDate;
import java.util.Date;

public class Exam {
	public short id;
	public String code;
	public String title;
	public Duration duration;
	public Teacher creator;
	public Question[] questions;
	public LocalDate createDate;
	
}
