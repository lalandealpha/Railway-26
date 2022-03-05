package backend.service;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> getUserList() throws SQLException;
    void printUserList() throws SQLException;
    User getUser(int id) throws SQLException;
    User getUser(String email) throws SQLException;
    User getAdmin(String email) throws SQLException;
    int deleteUser(int id) throws SQLException;
    void login(String email, String password) throws Exception;
    void createUser(String email, String password) throws Exception;
    void closeConnection() throws SQLException;
}
