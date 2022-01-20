package com.vti.backend.repository;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.utils.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements IProjectRepository{
    Manager manager;
    Employee employee;
    List<Employee> employees;
    Connection connection;
    JdbcUtils jdbcUtils;

    public ProjectRepository () throws SQLException, IOException, ClassNotFoundException {
        employees = new ArrayList<>();
        jdbcUtils = new JdbcUtils();
        connection = jdbcUtils.connectToDb("/Users/user/Code/FinalExam/src/main/source/database.properties");
    }

    @Override
    public Project getProject(String projectName) throws SQLException, IOException, ClassNotFoundException {
        int projectId = 0;
        // get ProjectManager
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM Manager JOIN Project ON Manager.ProjectId = Project.ProjectId WHERE ProjectName = ?");
        preparedStatement1.setString(1, projectName);
        ResultSet resultSetManger = preparedStatement1.executeQuery();
        while (resultSetManger.next()) {
            manager = new Manager(resultSetManger.getInt("ManagerId"), resultSetManger.getString("Fullname"), resultSetManger.getString("Email"), resultSetManger.getString("Password"), resultSetManger.getInt("ExpInYear"));
            projectId = resultSetManger.getInt("ProjectId");
        }

        // Get ProjectEmployee
        PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM Employee JOIN Project ON Employee.ProjectId = Project.ProjectId WHERE ProjectName = ?");
        preparedStatement2.setString(1, projectName);
        ResultSet resultSetEmployee = preparedStatement2.executeQuery();
        while (resultSetEmployee.next()) {
            employee = new Employee(resultSetEmployee.getInt("EmployeeId"), resultSetEmployee.getString("Fullname"), resultSetEmployee.getString("Email"), resultSetEmployee.getString("Password"), resultSetEmployee.getString("ProSkill"));
            employees.add(employee);
        }

        // Calculate team size
        int teamSize = employees.size() + 1;

        // Init project
        Project project = new Project(projectId, teamSize, projectName, manager, employees);

        return project;
    }

    public void closeConnection() throws SQLException {
        if (jdbcUtils.isDbConnected(connection)) {
            connection.close();
        }
    }
}
