package com.vti.entity;

/**
 * This class is Admin. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class Admin extends User {
	private int ExpInYear;

	/**
	 * Constructor for class Admin.
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param id
	 * @param fullName
	 * @param email
	 * @param password
	 * @param expInYear
	 */
	public Admin(int id, String fullName, String email, String password, int expInYear) {
		super(id, fullName, email, password);
		ExpInYear = expInYear;
	}

	/**
	 * @return the expInYear
	 */
	public int getExpInYear() {
		return ExpInYear;
	}

	/**
	 * @param expInYear the expInYear to set
	 */
	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}


}
