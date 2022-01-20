package com.vti.backend.service;


import com.vti.backend.repository.IUserRepository;
import com.vti.backend.repository.UserRepository;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    IUserRepository userRepository;

    public UserService() throws SQLException, IOException, ClassNotFoundException {
        userRepository = new UserRepository();
    }

    @Override
    public List<User> getUserList() throws SQLException {
        return userRepository.getUserList();
    }

    @Override
    public User getUser(String email) throws SQLException {
        return userRepository.getUser(email);
    }

    @Override
    public User getAdmin(String email) throws SQLException {
        return userRepository.getAdmin(email);
    }


    @Override
    public void login(String email, String password) throws Exception {
        if (getUser(email) == null) {
            System.err.println(("The email you entered is not connected to any accounts!"));
        } else {
            if (userRepository.login(email, password)) {
                System.out.println("Logged in!");
            } else {
                System.err.println(("Password incorrect!"));
            }
        }
    }

    @Override
    public void createUser(String email, String password) throws Exception {
        if (getUser(email) != null) {
            System.err.println(("User exists!"));
        } else {
            int affectedRecordAmount = userRepository.createUser(email, password);
            System.out.println("Account created!");
            System.out.println("Affected record(s) amount: " + affectedRecordAmount);
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        userRepository.closeConnection();
    }
}
