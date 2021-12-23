package com.vti.entity.abstraction;

import java.util.ArrayList;
import java.util.List;

public class VietnamesePhone extends Phone {
	
	public VietnamesePhone() {
		this.contacts = new ArrayList<Contact>();
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	@Override
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public void insertContact(String name, String number) {
		Contact contact = new Contact(name, number);
		contacts.add(contact);
		
	}

	@Override
	public void removeContact(String name) {
		for (Contact c : contacts) {
			if(c.getName().equals(name)) {
				contacts.remove(c);
			}
		}
	}

	@Override
	public void updateContact(String name, String newNumber) {
		for (int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getName().equals(name)) {
				contacts.get(i).setNumber(newNumber);
			}
		}
		
	}

	@Override
	public void searchContact(String name) {
		for (Contact c : contacts) {
			if(c.getName().equals(name)) {
				System.out.println(c.toString());
			}
		}
		
	}

}
