package com.vti.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

/**
 * This class is IUserService. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 14 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 14 thg 1, 2022
 */
public interface IUserService {
	/**
	 * This method is for getting a list of all Users. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @return
	 * @throws SQLException
	 */
	List<User> getUserList() throws SQLException;
	
	/**
	 * This method is for getting an User's information. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	User getUserInfor(int id) throws SQLException;
	/**
	 * This method is for getting an User's information. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	User getUserInfor(String email) throws SQLException;
	
	/**
	 * This method is for deleting an User. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws Exception 
	 */
	int deleteUser(int id) throws SQLException, Exception;
	
	/**
	 * This method is for logging in. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @param email
	 * @param password
	 * @throws SQLException
	 * @throws Exception 
	 */
	void login(String email, String password) throws SQLException, Exception;
	
	/**
	 * This method is for Admin logging in. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 15 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 15 thg 1, 2022
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	boolean loginForAdmin(String email, String password) throws SQLException;

	/**
	 * This method is for creating User account. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 15 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 15 thg 1, 2022
	 * @param email
	 * @param fullname
	 * @return
	 * @throws Exception
	 */
	int createUser(String email, String fullname) throws Exception;

}
