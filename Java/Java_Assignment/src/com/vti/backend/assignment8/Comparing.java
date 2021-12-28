package com.vti.backend.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.vti.entity.comparing.Student;

public class Comparing {
	List<Student> students;

	public Comparing() {
		students = new ArrayList<>();
		students.add(new Student(1, "Le Thi Lich", LocalDate.of(1956, 8, 30), 10f));
		students.add(new Student(2, "Nguyen Thanh Luan", LocalDate.of(1994, 8, 26), 7.5f));
		students.add(new Student(3, "Nguyen The An", LocalDate.of(1999, 12, 10), 8.0f));
		students.add(new Student(5, "Nguyen Thanh Luan", LocalDate.of(1998, 1, 16), 8.0f));
		students.add(new Student(6, "Nguyen Thanh Luan", LocalDate.of(1994, 8, 26), 6.6f));
	}

	public void Question1() {
		System.out.println("-------Question 1-------");
		Collections.sort(students);
		System.out.println(students);
	}

	public void Question2() {
		System.out.println("-------Question 2-------");
		Collections.sort(students, new Comparator<Student> () {
			@Override
			public int compare(Student s1, Student s2) {
				if(!s1.getName().equals(s2.getName())) {
					return s1.getName().compareTo(s2.getName());
				} else {
					int day1 = (int) s1.getBirthday().toEpochDay();
					int day2 = (int) s2.getBirthday().toEpochDay();
					if(!(day1 == day2)) {
						return day1 < day2 ? 1 : -1;
					} else {
						return s1.getMark() > s2.getMark() ? 1 : -1;
					}	
				}
			}		
		});
		System.out.println(students);
	}
}
