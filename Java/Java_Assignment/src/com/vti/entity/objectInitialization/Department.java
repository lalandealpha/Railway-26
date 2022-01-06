package com.vti.entity.objectInitialization;

public class Department {
	private int id;
	private String name;
	private Student[] students;
	private Teacher[] teachers;

	public Department() {

	}

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getStudents() {
		String result = "";
		if (students == null) {
			result += "There are no students in this department.";
		} else {
			for (Student s : students) {
				result += "\n" + s.getFullName();
			}
		}
		return result;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public Student[] getStudentsArray() {
		Student[] result = students;
		return result;
	}

	public String getTeachers() {
		String result = "";
		if (teachers == null) {
			result += "There are no teachers in this department.";
		} else {
			for (Teacher t : teachers) {
				result += "\n" + t.getFullName();
			}
		}
		return result;
	}

	public void setTeachers(Teacher[] teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		String result = "ID: " + id + "\nName: " + name + "\nStudent: ";
		if (students == null) {
			result += "There are no students in this department.";
		} else {
			for (Student s : students) {
				result += "\n" + s.getFullName();
			}
		}
		result += "\nTeacher: ";
		if (teachers == null) {
			result += "There are no teachers in this department.";
		} else {
			for (Teacher t : teachers) {
				result += "\n" + t.getFullName();
			}
		}

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Department deparmentX = (Department) obj;
		if (id == deparmentX.id && name.equals(deparmentX.name)) {
			return true;
		} else {
			return false;
		}
	}

}
