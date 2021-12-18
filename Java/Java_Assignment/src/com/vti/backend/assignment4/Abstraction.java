package com.vti.backend.assignment4;

import java.util.Scanner;

import com.vti.entity.abstraction.Contact;
import com.vti.entity.abstraction.VietnamesePhone;

public class Abstraction {
	
	VietnamesePhone vp = new VietnamesePhone();
	
	public void Question1a() {
		System.out.println("-------Question 1a-------");
		System.out.println("Create 2 abstract classes and abstract methods in com.vti.entity.abstraction");
	}
	
	public void Question1b1() {
		
		System.out.println("-------Question 1b1-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter new contact's name:");
		String nameInput = scanner.nextLine();
		System.out.println("Please enter new contact's phone number:");
		String numberInput = scanner.nextLine();
		vp.insertContact(nameInput, numberInput);
		System.out.println(vp.getContacts().toString());		
	}

	public void Question1b2() {
		Contact contact1 = new Contact("Grace Godber", "588-346-4950");
		Contact contact2 = new Contact("Donny Rosone", "870-411-9262");
		Contact contact3 = new Contact("Deana Mattei", "792-600-8022");
		Contact contact4 = new Contact("Harv Hebden", "616-842-0079");
		Contact contact5 = new Contact("Daphne Chalcraft", "523-694-8250");
		Contact contact6 = new Contact("Thaddeus Bicheno", "282-238-8038");
		
		vp.getContacts().add(contact1);
		vp.getContacts().add(contact2);
		vp.getContacts().add(contact3);
		vp.getContacts().add(contact4);
		vp.getContacts().add(contact5);
		vp.getContacts().add(contact6);
		
		System.out.println("-------Question 1b2-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter new contact's name:");
		String nameInput = scanner.nextLine();
		vp.removeContact(nameInput);
		
		System.out.println(vp.getContacts().toString());
		
	}
}
