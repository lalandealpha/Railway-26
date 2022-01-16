//
package com.vti.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

/**
 * This class is .
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 14 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 14 thg 1, 2022
 */
/**
 * This class is . 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 14 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 14 thg 1, 2022
 */
public class UserRepository implements IUserRepository{
	JdbcUtils jdbcUtils = new JdbcUtils();
	Connection connection;

	/**
	 * Constructor for class UserRepository.
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public UserRepository() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		jdbcUtils = new JdbcUtils();
		connection = jdbcUtils.connectToDb("/Users/user/Code/FinalExam/src/main/source/database.properties");
	}
	
	/* 
	* @see com.vti.backend.repository.IUserRepository#getUserList()
	*/
	@Override
	public List<User> getUserList() throws SQLException {
		List<User> users = new ArrayList<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet1 = statement.executeQuery("SELECT * FROM `User` WHERE `Role` = 'Admin'");
		while (resultSet1.next()) {
			User user = new Admin(resultSet1.getInt("Id"), resultSet1.getString("Fullname"),
					resultSet1.getString("Email"), resultSet1.getString("Password"), resultSet1.getInt("ExpInYear"));
			users.add(user);
		}
		
		ResultSet resultSet2 = statement.executeQuery("SELECT * FROM `User` WHERE `Role` = 'Employee'");
		while (resultSet2.next()) {
			User user = new Employee(resultSet2.getInt("Id"), resultSet2.getString("Fullname"),
					resultSet2.getString("Email"), resultSet2.getString("Password"), resultSet2.getString("ProSkill"));
			users.add(user);
		}
		
		return users;
	}
	
	/* 
	* @see com.vti.backend.repository.IUserRepository#getUserInfor(int)
	*/
	@Override
	public User getUserInfor(int id) throws SQLException {
		User user = null;
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `User` WHERE Id = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			user = new User(id, resultSet.getString("Fullname"), resultSet.getString("Email"), resultSet.getString("Password"));
		}
		return user;
	}
	
	/* 
	* @see com.vti.backend.repository.IUserRepository#deleteUser(int)
	*/
	@Override
	public int deleteUser(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `User` WHERE Id = ?");
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate();
	}
	
	/* 
	* @see com.vti.backend.repository.IUserRepository#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String email, String password) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `User` WHERE Email = ? AND Password = ?");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	
	/* 
	* @see com.vti.backend.repository.IUserRepository#createUser(java.lang.String, java.lang.String)
	*/
	@Override
	public int createUser(String email, String fullname) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `User` (Email, Fullname, `Password`, `Role`) VALUES (?, ?, '123456', 'Employee')");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, fullname);
		return preparedStatement.executeUpdate();
	}

	/* 
	* @see com.vti.backend.repository.IUserRepository#loginForAdmin(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean loginForAdmin(String email, String password) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `User` WHERE Email = ? AND Password = ? AND `Role` = 'Admin'");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	/* 
	* @see com.vti.backend.repository.IUserRepository#getUserInfor(java.lang.String)
	*/
	@Override
	public User getUserInfor(String email) throws SQLException {
		User user = null;
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `User` WHERE Email = ?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			user = new User(resultSet.getInt("Id"), resultSet.getString("Fullname"), email, resultSet.getString("Password"));

		}
		return user;
	}


	
	
}
