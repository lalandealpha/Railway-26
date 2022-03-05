package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.generic.Employee;
import com.vti.entity.generic.MyMap;
import com.vti.entity.generic.Phone;
import com.vti.entity.generic.Staff;
import com.vti.entity.generic.Student;

public class Generic <E extends Number>{
	
	public void Question1() {
		System.out.println("-------Question 1-------");
		Student<Integer> student1 = new Student<>(1, "Nguyen Thanh Luan");
		Student<Float> student2 = new Student<>(2f, "Nguyen The An");
		Student<Double> student3 = new Student<>(3d, "Le Thi Lich");
	}
	
	public void Question2() {
		System.out.println("-------Question 2-------");
		Student<Integer> student1 = new Student<>(1, "Nguyen Thanh Luan");
		student1.print(1, 2);
		student1.print("Testing generic for methods", "Testing generic for methods...");
	}
	
	public void Question4() {
		System.out.println("-------Question 3-------");
		Student<Integer> student1 = new Student<>(1, "Nguyen Thanh Luan");
		List<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(2);
		student1.print(a1);
		
		List<Float> a2 = new ArrayList<>();
		a2.add(3f);
		a2.add(4f);
		student1.print(a2);
		
		List<Long> a3 = new ArrayList<>();
		a3.add(5l);
		a3.add(6l);
		student1.print(a3);
		
		List<Double> a4 = new ArrayList<>();
		a4.add(7d);
		a4.add(8d);
		student1.print(a4);
	}
	
	public void Question5() {
		System.out.println("-------Question 5-------");
		List<Integer> salariesOfEmp1 = new ArrayList<>();
		salariesOfEmp1.add(2348);
		salariesOfEmp1.add(6782);
		salariesOfEmp1.add(6728);
		salariesOfEmp1.add(2372);
		salariesOfEmp1.add(4546);
		Employee<Integer> emp1 = new Employee<>("Nguyen Thanh Luan", salariesOfEmp1);
		
		List<Float> salariesOfEmp2 = new ArrayList<>();
		salariesOfEmp2.add(9345f);
		salariesOfEmp2.add(4599f);
		salariesOfEmp2.add(9237f);
		salariesOfEmp2.add(1634f);
		Employee<Float> emp2 = new Employee<>("Nguyen The An", salariesOfEmp2);
		
		List<Double> salariesOfEmp3 = new ArrayList<>();
		salariesOfEmp3.add(8293d);
		salariesOfEmp3.add(6386d);
		salariesOfEmp3.add(2385d);
		salariesOfEmp3.add(5923d);
		salariesOfEmp3.add(2662d);
		Employee<Double> emp3 = new Employee<>("Le Thi Lich", salariesOfEmp3);
		
		Employee[] employees = { emp1, emp2, emp3 };
		for (int i = 0; i < employees.length; i++) {
			System.out.println("Information of employee" + (i + 1) + ": ");
			System.out.println(employees[i].toString());
			System.out.println("Last salary is:");
			System.out.println(employees[i].getLastSalary() +"\n");
		}
	
	}

	public void Question6() {
		System.out.println("-------Question 6-------");
		MyMap<Integer, String> student = new MyMap<Integer, String>();
		student.setKey(1);
		student.setValue("Nguyen Thanh Luan");
	}
	
	public void Question7() {
		System.out.println("-------Question 7-------");
		// Phone(email, phoneNumber)
		Phone<String, String> phone1 = new Phone<>("luannt@gmail.com", "0123 456 789");
		// Phone(ordinalNumber, phoneNumber)
		Phone<Integer, String> phone2 = new Phone<>(1, "035 553 2561");
		// Phone(name, phoneNumber)
		Phone<String, String> phone3 = new Phone<>("Luan Nguyen", "035 897 2856");
		
		System.out.println(phone1.getKey());
		System.out.println(phone1.getPhone());
		
	}
	
	public void Question8() {
		System.out.println("-------Question 8-------");
		Staff<Integer, String> staff = new Staff<>(1, "Luan Nguyen");
		System.out.println(staff.getId());
		System.out.println(staff.getName());
	}
}
