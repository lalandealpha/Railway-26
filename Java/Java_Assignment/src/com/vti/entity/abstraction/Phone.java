package com.vti.entity.abstraction;

import java.util.List;

public abstract class Phone {
	protected List<Contact>  contacts;
	
	public abstract void setContacts(List<Contact> contacts);
	
	public abstract void insertContact(String name, String number);
	
	public abstract void removeContact(String name);
	
	public abstract void updateContact(String name, String newNumber);
	
	public abstract void searchContact(String name);
}
