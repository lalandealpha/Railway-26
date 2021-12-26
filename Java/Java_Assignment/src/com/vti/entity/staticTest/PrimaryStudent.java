package com.vti.entity.staticTest;

public final class PrimaryStudent extends Student {
	public static int countps = 0;

	public PrimaryStudent() {
		if (PrimaryStudent.countps + SecondaryStudent.countss < 7) {
			countps++;
		}
	}

	public PrimaryStudent(String name) {
		if (PrimaryStudent.countps + SecondaryStudent.countss < 7) {
			countps++;
			this.name = name;
		}
	}
}
