package com.vti.frontend;

import com.vti.backend.MyMath;

public class MyMathProgram {

	public static void main(String[] args) {
		System.out.println("-------Question 4-------");
		MyMath pro = new MyMath();
		System.out.println(pro.sum(3.5f, 5));
		System.out.println(pro.sum(6, 2.2f));
		System.out.println(pro.sum(10, 4));
	}

}
