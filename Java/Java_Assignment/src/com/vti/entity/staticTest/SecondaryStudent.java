package com.vti.entity.staticTest;

public final class SecondaryStudent extends Student {
	public static int countss = 0;

	public SecondaryStudent() {
		if (PrimaryStudent.countps + SecondaryStudent.countss < 7) {
			countss++;
		}
	}

	public SecondaryStudent(String name) {
		if (PrimaryStudent.countps + SecondaryStudent.countss < 7) {
			countss++;
			this.name = name;
		}
	}
}
