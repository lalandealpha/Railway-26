package com.vti.backend.utils;

public class StringMethodsUtils {
	
	public static String reverseWord(String string) {
		String[] words = string.split("\\s");
		String result = "";
		for (String w : words) {
			StringBuilder sb = new StringBuilder(w);
			sb.reverse();
			result += sb.toString() + " ";
		}
		return result.trim();
	}
}
