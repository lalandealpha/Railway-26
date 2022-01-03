package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.vti.entity.Student;

public class Exercise1 {
	public void Question() {
		List<String> lastNames = new ArrayList<>();
		lastNames.add("Nguyen");
		lastNames.add("Tran");
		lastNames.add("Le");
		lastNames.add("Pham");
		lastNames.add("Hoang");
		lastNames.add("Phan");
		lastNames.add("Vo");
		
		List<String> middleNames = new ArrayList<>();
		middleNames.add("Hai");
		middleNames.add("Ha");
		middleNames.add("Hanh");
		middleNames.add("Thanh");
		middleNames.add("Nhung");
		middleNames.add("Ba");
		middleNames.add("Hai");

		List<String> firstNames = new ArrayList<>();
		firstNames.add("Duong");
		firstNames.add("Phong");
		firstNames.add("Danh");
		firstNames.add("Nhung");
		firstNames.add("Chung");
		firstNames.add("Chi");
		firstNames.add("Bao");
		
		Random random = new Random();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String fullName = lastNames.get(random.nextInt(lastNames.size())) + " "
							+ middleNames.get(random.nextInt(middleNames.size())) + " "
							+ firstNames.get(random.nextInt(firstNames.size()));
			Student student = new Student(fullName);
			Set<String> ids = new HashSet<>();
			for (int j = 0; j < 50; j++) {
				ids.add("SV" + (random.nextInt(8999999 + 1) + 1000000));
			}
			student.setId(ids.toArray()[i].toString());
			int minDay = (int) LocalDate.of(1991, 2, 1).toEpochDay();
			int maxDay = (int) LocalDate.of(1991, 12, 31).toEpochDay();
			Set<Integer> birthdays = new HashSet<>();
			for (int j = 0; j < 50; j++) {
				birthdays.add(minDay + random.nextInt(maxDay - minDay + 1));
			}
			int randomInt = (int) birthdays.toArray()[i];
			LocalDate birthday = LocalDate.ofEpochDay(randomInt);
			student.setBirthday(birthday);
			students.add(student);
		}
		System.out.println("+--------------------+-----------+-----------+");
		System.out.printf("|%-20s|%-11s|%-11s|\n", "Fullname", "ID", "Birthday");
		System.out.println("+--------------------+-----------+-----------+");
		for (Student s : students) {
			System.out.printf("|%-20s|%-11s|%-11s|\n", s.getFullname(), s.getId(), s.getBirthday());
		}
	}
}
