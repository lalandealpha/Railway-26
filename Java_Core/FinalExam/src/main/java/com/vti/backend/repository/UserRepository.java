package com.vti.backend.repository;

import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    static Connection connection;
    static JdbcUtils jdbcUtils;

    public UserRepository() throws SQLException, IOException, ClassNotFoundException {
        jdbcUtils = new JdbcUtils();
        connection = jdbcUtils.connectToDb("/Users/user/Code/FinalExam/src/main/source/database.properties");
    }

    @Override
    public List<User> getUserList() throws SQLException {
        Statement statement = connection.createStatement();
        List<User> users = new ArrayList<>();
        // get all admins
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM Admin");
        while (resultSet1.next()) {
            User user = new Admin(resultSet1.getInt("AdminId"), resultSet1.getString("Fullname"),
                    resultSet1.getString("Email"), resultSet1.getString("Password"));
            users.add(user);
        }
        // get all employees
        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM Employee");
        while (resultSet2.next()) {
            User user = new Employee(resultSet2.getInt("EmployeeId"), resultSet2.getString("Fullname"),
                    resultSet2.getString("Email"), resultSet2.getString("Password"), resultSet2.getString("ProSkill"));
            users.add(user);
        }

        ResultSet resultSet3 = statement.executeQuery("SELECT * FROM Manager");
        while (resultSet3.next()) {
            User user = new Manager(resultSet3.getInt("ManagerId"), resultSet3.getString("Fullname"),
                    resultSet3.getString("Email"), resultSet3.getString("Password"), resultSet3.getInt("ExpInYear"));
            users.add(user);
        }
        return users;
    }

    @Override
    public User getUser(String email) throws SQLException {
        List<User> users = getUserList();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getAdmin(String email) throws SQLException {
        User admin = null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT AdminId, Fullname, Email, `Password` FROM `Admin` WHERE Email = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            admin = new User(resultSet.getInt("AdminId"), resultSet.getString("Fullname"), resultSet.getString("Email"), resultSet.getString("Password"));
        }
        return admin;
    }

    @Override
    public boolean login(String email, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT Email, `Password` FROM Admin WHERE Email = ? AND Password = ? UNION SELECT  Email, `Password` FROM Employee WHERE Email = ? AND Password = ? UNION SELECT Email, `Password` FROM Manager WHERE Email = ? AND Password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.setString(5, email);
        preparedStatement.setString(6, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    @Override
    public int createUser(String email, String fullName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `Employee` (Email, Fullname, `Password`) VALUES (?, ?, '123456')");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, fullName);
        return preparedStatement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        if (jdbcUtils.isDbConnected(connection)) {
            connection.close();
        }
    }
}
