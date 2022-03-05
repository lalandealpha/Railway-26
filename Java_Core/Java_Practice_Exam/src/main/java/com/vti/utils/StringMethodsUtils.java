package com.vti.utils;

/**
 * This class is String method utils. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class StringMethodsUtils {
	
	/**
	 * This method is for reversing characters in each words. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param string
	 * @return
	 */
	public String reverseWord(String string) {
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
