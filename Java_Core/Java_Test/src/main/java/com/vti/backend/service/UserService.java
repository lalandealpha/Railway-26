//
package com.vti.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.repository.IUserRepository;
import com.vti.backend.repository.UserRepository;
import com.vti.entity.User;

/**
 * This class is . 
 * 
 * @Description: UserService.
 * @author: LuanNT
 * @create_date: 14 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 14 thg 1, 2022
 */
public class UserService implements IUserService {
	IUserRepository repository;
	
	public UserService() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		repository = new UserRepository();
	}

	/* 
	* @see com.vti.backend.service.IUserService#getUserList()
	*/
	@Override
	public List<User> getUserList() throws SQLException {
		return repository.getUserList();
	}

	/* 
	* @see com.vti.backend.service.IUserService#getUserInfor(int)
	*/
	@Override
	public User getUserInfor(int id) throws SQLException {
		return repository.getUserInfor(id);
	}

	/* 
	* @see com.vti.backend.service.IUserService#deleteUser(int)
	*/
	@Override
	public int deleteUser(int id) throws Exception {
		if(getUserInfor(id) ==  null) {
			throw new Exception("User not found!");
		} else {
			return repository.deleteUser(id);
		}
	}

	/* 
	* @see com.vti.backend.service.IUserService#login(java.lang.String, java.lang.String)
	*/
	@Override
	public void login(String email, String password) throws Exception {
		if(repository.login(email, password)) {
			System.out.println("Logged in!");
		} else {
			throw new Exception("The email or password you’ve entered is incorrect.");
		}
	}

	/* 
	* @see com.vti.backend.service.IUserService#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	*/
	@Override
	public int createUser(String email, String fullname) throws Exception {
		if(getUserInfor(email) != null) {
			throw new Exception("User exists!");
		} else {
			return repository.createUser(email, fullname);
		}	
	}

	/* 
	* @see com.vti.backend.service.IUserService#loginForAdmin(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean loginForAdmin(String email, String password) throws SQLException {
		return repository.loginForAdmin(email, password);
	}

	@Override
	public User getUserInfor(String email) throws SQLException {
		return repository.getUserInfor(email);
	}

}
