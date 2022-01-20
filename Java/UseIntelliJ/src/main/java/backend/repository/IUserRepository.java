package backend.repository;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    List<User> getUserList() throws SQLException;
    void printUserList() throws SQLException;
    User getUser(int id) throws SQLException;
    User getUser(String email) throws SQLException;
    User getAdmin(String email) throws SQLException;
    int deleteUser(int id) throws SQLException;
    boolean login(String email, String password) throws SQLException;
    int createUser(String email, String password) throws SQLException;
    void closeConnection() throws SQLException;
}
