package com.vti.backend.assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import com.vti.backend.utils.ScannerUtils;
import com.vti.entity.collection.Student;

public class Collection {
	List<Student> students;

	public Collection() {
		students = new ArrayList<>();
		students.add(new Student("Nguyen Thanh Luan"));
		students.add(new Student("Nguyen Thanh Luanl"));
		students.add(new Student("Nguyen Thanh Luan"));
		students.add(new Student("Nguyen Thanh Luan"));
	}

	public void Question1a() {
		System.out.println("-------Question 1a-------");
		System.out.println(students.size());
	}

	public void Question1b() {
		System.out.println("-------Question 1b-------");
		System.out.println(students.get(3).toString());
	}

	public void Question1c() {
		System.out.println("-------Question 1c-------");
		System.out.println(students.get(0).toString());
		System.out.println(students.get(students.size() - 1));
	}

	public void Question1d() {
		System.out.println("-------Question 1d-------");
		students.add(0, new Student("Le Thi Lich"));
		System.out.println("Student added successfully!");
	}

	public void Question1e() {
		System.out.println("-------Question 1e-------");
		students.add(new Student("Nguyen The An"));
		System.out.println("Student added successfully!");
	}

	public void Question1f() {
		System.out.println("-------Question 1f-------");
		Collections.reverse(students);
		for (Student s : students) {
			System.out.println(s.toString());
		}
	}

	public void Question1g() {
		System.out.println("-------Question 1g-------");
		System.out.println("Please enter the student's id:");
		int idInput = ScannerUtils.inputID("ID must be an integer and greater than 0. Please try again!");
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == idInput) {
				System.out.println(students.get(i).toString());
			} else {
				System.out.println("Student not found!");
			}
		}
	}

	public void Question1h() {
		System.out.println("-------Question 1h-------");
		System.out.println("Please enter the student's name:");
		String nameInput = ScannerUtils.inputString();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName() == nameInput) {
				System.out.println(students.get(i).toString());
			} else {
				System.out.println("Student not found!");
			}
		}
	}

	public void Question1i() {
		System.out.println("-------Question 1i-------");
		Set<Student> studentTemp = new HashSet<>();
		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j < students.size(); j++) {
				if (students.get(i).getName().equals(students.get(j).getName())) {
					studentTemp.add(students.get(i));
					studentTemp.add(students.get(j));
				}
			}
		}
		for (Student s : studentTemp) {
			System.out.println(s.toString());
		}
		
	}

	public void Question1j() {
		System.out.println("-------Question 1j-------");
		for (Student s : students) {
			if (s.getId() == 2) {
				s.setName(null);
			}
		}
		System.out.println("Student's name deleted.");
	}

	public void Question1k() {
		System.out.println("-------Question 1k-------");
		Student temp = null;
		for (Student s : students) {
			if (s.getId() == 5) {
				temp = s;
			}
		}
		students.remove(temp);
		System.out.println("Student deleted!");
	}

	public void Question1l() {
		System.out.println("-------Question 1l-------");
		List<Student> studentCopies = new ArrayList<>();
		studentCopies.addAll(students);
		System.out.println("All the students copied.");
	}

	public void Question2a() {
		System.out.println("-------Question 2a-------");
		Stack<Student> studentStack = new Stack<>();
		studentStack.push(new Student("Nguyen Van Nam"));
		studentStack.push(new Student("Nguyen Van Huyen"));
		studentStack.push(new Student("Trinh Van Hoang"));
		studentStack.push(new Student("Tran Huynh"));
		try {
			while (!studentStack.isEmpty()) {
				System.out.println(studentStack.pop().toString());
			}
		} catch (Exception e) {
		}

	}

	public void Question2b() {
		System.out.println("-------Question 2b-------");
		Queue<Student> studentQueue = new LinkedList<>();
		studentQueue.add(new Student("Nguyen Van Nam"));
		studentQueue.add(new Student("Nguyen Van Huyen"));
		studentQueue.add(new Student("Trinh Van Hoang"));
		studentQueue.add(new Student("Tran Huynh"));

		try {
			while (studentQueue != null)
				System.out.println(studentQueue.poll().toString());
		} catch (Exception e) {
		}
	}

	public void Question6() {
		System.out.println("-------Question 6-------");
		Map<Integer, Student> studentsMap = new HashMap<>();
		studentsMap.put(1, new Student("Nguyen Van Nam"));
		studentsMap.put(2, new Student("Nguyen Van Huyen"));
		studentsMap.put(3, new Student("Trinh Van Hoang"));
		studentsMap.put(4, new Student("Tran Huynh"));
	}

	public void Question7() {
		Map<Integer, String> studentsMap = new HashMap<>();
		studentsMap.put(1, "Nguyen Van Nam");
		studentsMap.put(2, "Nguyen Van Huyen");
		studentsMap.put(3, "Trinh Van Hoang");
		studentsMap.put(4, "Tran Huynh");

		System.out.println("-------Question 7a-------");
		System.out.println(studentsMap.keySet());

		System.out.println("-------Question 7b-------");
		for (int j = 0; j < studentsMap.size(); j++) {
			System.out.println(studentsMap.get(j + 1));
		}

		System.out.println("-------Question 7c-------");
		List<String> studentByName = new ArrayList<>(studentsMap.values());
		Collections.sort(studentByName);
		System.out.println(studentByName);
		
		System.out.println("-------Question 7d-------");
		Set<Student> studentsSet = new HashSet<>();
		for (int i = 0; i < studentsMap.size(); i++) {
			studentsSet.add(new Student(studentsMap.get(i + 1)));
		}
		System.out.println(studentsSet);

	}
}






























