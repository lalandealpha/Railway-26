package com.vti.entity.abstraction;

import java.util.List;

public class VietnamesePhone extends Phone {
	
	private List<Contact>  contacts;
	
	public List<Contact> getContacts() {
		return contacts;
	}

	@Override
	public void insertContact(String name, String number) {
		Contact contact = new Contact(name, number);
		contacts.add(contact);
		
	}

	@Override
	public void removeContact(String name) {
		for (int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getName().equals(name)) {
				contacts.remove(i);
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
		for (int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getName().equals(name)) {
				contacts.get(i).toString();
			}
		}
		
	}

}
