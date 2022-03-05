package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

import com.vti.backend.utils.ScannerUtils;

public class SequenceNumber {
	
	public int input() {
		System.out.println("Nhập dãy số:");
		return ScannerUtils.inputInt("Please try again!");
	}
	
	public void print() {
		System.out.println(input());
	}
	
	public SequenceNumber(int n) {
		List<Integer> list = new ArrayList<Integer>(n);
	}
}
