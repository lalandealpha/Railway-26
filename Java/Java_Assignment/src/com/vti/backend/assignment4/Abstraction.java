package com.vti.backend.assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.abstraction.Contact;
import com.vti.entity.abstraction.VietnamesePhone;

public class Abstraction {
	
	
	
	public void Question1a() {
		VietnamesePhone vp = new VietnamesePhone();
		System.out.println("-------Question 1a-------");
		System.out.println("Create 2 abstract classes and abstract methods in com.vti.entity.abstraction");
	}
	
	public void Question1b1() {
		VietnamesePhone vp = new VietnamesePhone();
		
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
		VietnamesePhone vp = new VietnamesePhone();
		Contact contact1 = new Contact("Grace Godber", "588-346-4950");
		Contact contact2 = new Contact("Donny Rosone", "870-411-9262");
		Contact contact3 = new Contact("Deana Mattei", "792-600-8022");
		Contact contact4 = new Contact("Harv Hebden", "616-842-0079");
		Contact contact5 = new Contact("Daphne Chalcraft", "523-694-8250");
		Contact contact6 = new Contact("Thaddeus Bicheno", "282-238-8038");
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		contacts.add(contact3);
		contacts.add(contact4);
		contacts.add(contact5);
		contacts.add(contact6);
		
		vp.setContacts(contacts);
		
		System.out.println("-------Question 1b2-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the contact's name you want to remove:");
		for (Contact c : contacts) {
			System.out.println(c.getName());
		}
		String nameInput = scanner.nextLine();
		vp.removeContact(nameInput);
		
		System.out.println(contacts.toString());
	}
	
	public void Question1b3() {
		VietnamesePhone vp = new VietnamesePhone();
		Contact contact1 = new Contact("Grace Godber", "588-346-4950");
		Contact contact2 = new Contact("Donny Rosone", "870-411-9262");
		Contact contact3 = new Contact("Deana Mattei", "792-600-8022");
		Contact contact4 = new Contact("Harv Hebden", "616-842-0079");
		Contact contact5 = new Contact("Daphne Chalcraft", "523-694-8250");
		Contact contact6 = new Contact("Thaddeus Bicheno", "282-238-8038");
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		contacts.add(contact3);
		contacts.add(contact4);
		contacts.add(contact5);
		contacts.add(contact6);
		
		vp.setContacts(contacts);
		
		System.out.println("-------Question 1b3-------");
		Scanner scanner = new Scanner(System.in);
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
		VietnamesePhone vp = new VietnamesePhone();
		Contact contact1 = new Contact("Grace Godber", "588-346-4950");
		Contact contact2 = new Contact("Donny Rosone", "870-411-9262");
		Contact contact3 = new Contact("Deana Mattei", "792-600-8022");
		Contact contact4 = new Contact("Harv Hebden", "616-842-0079");
		Contact contact5 = new Contact("Daphne Chalcraft", "523-694-8250");
		Contact contact6 = new Contact("Thaddeus Bicheno", "282-238-8038");
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		contacts.add(contact3);
		contacts.add(contact4);
		contacts.add(contact5);
		contacts.add(contact6);
		
		vp.setContacts(contacts);
		
		System.out.println("-------Question 1b4-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter contact's name:");
		String nameInput = scanner.nextLine();
		System.out.println("Information of the contact you just entered:");
		vp.searchContact(nameInput);
	}
}
