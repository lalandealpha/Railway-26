package com.vti.backend.service;

import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> getUserList() throws SQLException;
    User getUser(String email) throws SQLException;
    User getAdmin(String email) throws SQLException;
    void login(String email, String password) throws Exception;
    void createUser(String email, String password) throws Exception;
    void closeConnection() throws SQLException;
}
