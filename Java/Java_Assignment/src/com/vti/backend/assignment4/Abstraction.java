package com.vti.backend.assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.abstraction.Contact;
import com.vti.entity.abstraction.VietnamesePhone;

public class Abstraction {
	Scanner scanner = new Scanner(System.in);
	VietnamesePhone vp = new VietnamesePhone();
	List<Contact> contacts = new ArrayList<Contact>();
	
	public Abstraction() {	
		contacts.add(new Contact("Grace Godber", "588-346-4950"));
		contacts.add(new Contact("Donny Rosone", "870-411-9262"));
		contacts.add(new Contact("Deana Mattei", "792-600-8022"));
		contacts.add(new Contact("Harv Hebden", "616-842-0079"));
		contacts.add(new Contact("Daphne Chalcraft", "523-694-8250"));
		contacts.add(new Contact("Thaddeus Bicheno", "282-238-8038"));	
		vp.setContacts(contacts);
	}
	
	public void Question1a() {
		System.out.println("-------Question 1a-------");
		System.out.println("Create 2 abstract classes and abstract methods in com.vti.entity.abstraction");
	}
	
	public void Question1b1() {
		
		System.out.println("-------Question 1b1-------");
		System.out.println("Please enter new contact's name:");
		String nameInput = scanner.nextLine();
		System.out.println("Please enter new contact's phone number:");
		String numberInput = scanner.nextLine();
		vp.insertContact(nameInput, numberInput);
		System.out.println(vp.getContacts().toString());		
	}

	public void Question1b2() {		
		System.out.println("-------Question 1b2-------");
		System.out.println("Please enter the contact's name you want to remove:");
		for (Contact c : contacts) {
			System.out.println(c.getName());
		}
		String nameInput = scanner.nextLine();
		vp.removeContact(nameInput);
		
		System.out.println(contacts.toString());
	}
	
	public void Question1b3() {	
		System.out.println("-------Question 1b3-------");
		System.out.println("Please enter contact's name:");
		for (Contact c : contacts) {
			System.out.println(c.getName());
		}
		String nameInput = scanner.nextLine();
		System.out.println("Please enter new phone number:");
		String numberInput = scanner.nextLine();
		vp.updateContact(nameInput, numberInput);
		System.out.println("You have just updated contact:");
		for (Contact c : contacts) {
			if(c.getName().equals(nameInput)) {
				System.out.println(c.toString());
			}
		}
	}
	
	public void Question1b4() {	
		System.out.println("-------Question 1b4-------");
		System.out.println("Please enter contact's name:");
		String nameInput = scanner.nextLine();
		System.out.println("Information of the contact you just entered:");
		vp.searchContact(nameInput);
	}
}
