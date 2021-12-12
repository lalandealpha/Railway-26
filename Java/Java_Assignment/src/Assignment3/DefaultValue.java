package Assignment3;

import java.time.LocalDate;
import java.util.Iterator;

import Assignment1.Teacher;

public class DefaultValue {

	public static void main(String[] args) {
		Teacher[] teachers = new Teacher[5];
		for (int i = 0; i < teachers.length; i++) {
			teachers[i] = new Teacher();
			teachers[i].id = i;
			teachers[i].email = "Email " + i;
			teachers[i].userName = "Username " + i;
			teachers[i].fullName = "Full name " + i;
			teachers[i].createDate = LocalDate.now();
		}
		
		for (Teacher t : teachers) {
			System.out.println("ID: " + t.id);
			System.out.println("Email: " + t.email);
			System.out.println("Username: " + t.userName);
			System.out.println("Full name: " + t.fullName);
			System.out.println("Created at: " + t.createDate);
			System.out.println("");
		}

	}

}
