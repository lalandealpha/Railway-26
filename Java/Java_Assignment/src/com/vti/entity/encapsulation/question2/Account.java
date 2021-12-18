package com.vti.entity.encapsulation.question2;

public class Account {
	String id;
	String name;
	int balance;
	
	public Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalnace() {
		return balance;
	}
	
	public void credit(int amount) {
		this.balance += amount;
	}
	
	public void debit(int amount) {
		this.balance -= amount;
	}
	
	public void transferTo(Account account, int amount) {
		account.balance += amount;
		this.balance -= amount;
	}
}
