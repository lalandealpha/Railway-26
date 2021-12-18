package com.vti.entity.encapsulation.question2;

public class Date {
	int day;
	int month;
	int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
	public boolean isLeapYear() {
		boolean isLeapYear = false;
	    // if the year is divided by 4
	    if (year % 4 == 0) {
	      // if the year is century
	    	if (year % 100 == 0) {

	        // if year is divided by 400
	        // then it is a leap year
	        if (year % 400 == 0)
	        	isLeapYear = true;
	        else
	        	isLeapYear = false;
	      } 
	      // if the year is not century
	      else
	    	  isLeapYear = true;
	    }	    
	    else
	    	isLeapYear = false;
	    return isLeapYear;
	}


}

