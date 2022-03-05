package com.vti.entity.generic;

import java.util.List;

import com.vti.backend.utils.ScannerUtils;

public class Employee<N extends Number> {
	private static int count = 0;
	private int id;
	private String name;
	private List<N> salaries;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<N> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<N> salaries) {
		this.salaries = salaries;
	}

	public Employee(String name, List<N> salaries) {
		super();
		this.id = ++count;
		this.name = name;
		this.salaries = salaries;
	}

	@Override
	public String toString() {
		String result = "";
		result += "ID: " + id + "\nName: " + name + "\nSalaries: ";
		for (N s : salaries) {
			result += "\n" + s;
		}
		return result;
	}
	
	public N getLastSalary() {
		return salaries.get(salaries.size() - 1);
	}
}
