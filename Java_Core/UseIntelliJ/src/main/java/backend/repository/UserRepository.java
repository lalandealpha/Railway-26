package backend.repository;

import entity.Admin;
import entity.Employee;
import entity.User;
import utils.JdbcUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    Connection connection;
    JdbcUtils jdbcUtils;

    public UserRepository() throws SQLException, IOException, ClassNotFoundException {
        jdbcUtils = new JdbcUtils();
        connection = jdbcUtils.connectToDb("/Users/user/Code/UseIntelliJ/src/main/source/database.properties");
    }

    @Override
    public List<User> getUserList() throws SQLException {
        Statement statement = connection.createStatement();
        List<User> users = new ArrayList<>();
        // get all admins
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM `Admin`");
        while (resultSet1.next()) {
            User user = new Admin(resultSet1.getInt("Id"), resultSet1.getString("Fullname"),
                    resultSet1.getString("Email"), resultSet1.getString("Password"), resultSet1.getInt("ExpInYear"));
            users.add(user);
        }
        // get all employees
        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM `Employee`");
        while (resultSet2.next()) {
            User user = new Employee(resultSet2.getInt("Id"), resultSet2.getString("Fullname"),
                    resultSet2.getString("Email"), resultSet2.getString("Password"), resultSet2.getString("ProSkill"));
            users.add(user);
        }
        return users;
    }

    @Override
    public void printUserList() throws SQLException {
        List<User> users = getUserList();
        System.out.println("Information of all users:");
        System.out.println("+---+--------------------+------------------------------+----------+");
        System.out.printf("|%-3s|%-20s|%-30s|%-10s|\n", "ID", "Fullname", "Email", "Position");
        System.out.println("+---+--------------------+------------------------------+----------+");
        for (User u : users) {
            System.out.printf("|%-3s|%-20s|%-30s|%-10s|\n", u.getId(), u.getFullName(), u.getEmail(),
                    (u instanceof Admin ? "Admin" : "Employee"));
            System.out.println("+---+--------------------+------------------------------+----------+");
        }
    }

    @Override
    public User getUser(int id) throws SQLException {
        List<User> users = getUserList();
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
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
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id, Fullname, Email, `Password` FROM `Admin` WHERE Email = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            admin = new User(resultSet.getInt("Id"), resultSet.getString("Fullname"), resultSet.getString("Email"), resultSet.getString("Password"));
        }
        return admin;
    }

    @Override
    public int deleteUser(int id) throws SQLException {
        PreparedStatement preparedStatement1 = connection.prepareStatement("DELETE FROM `Admin` WHERE Id = ?");
        preparedStatement1.setInt(1, id);
        int affectedRecordAmount = preparedStatement1.executeUpdate();
        PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM `Employee` WHERE Id = ?");
        preparedStatement2.setInt(1, id);
        affectedRecordAmount += preparedStatement2.executeUpdate();
        return affectedRecordAmount;
    }

    @Override
    public boolean login(String email, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT Email, `Password` FROM `Admin` WHERE Email = ? AND Password = ? UNION SELECT  Email, `Password` FROM `Employee` WHERE Email = ? AND Password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
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
