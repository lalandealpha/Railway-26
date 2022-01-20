package com.vti.backend.service;

import com.vti.backend.repository.IProjectRepository;
import com.vti.backend.repository.ProjectRepository;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProjectService implements IProjectService {
    IProjectRepository projectRepository;

    public ProjectService () throws SQLException, IOException, ClassNotFoundException {
        projectRepository = new ProjectRepository();
    }

    @Override
    public void getProject(String projectName) throws SQLException, IOException, ClassNotFoundException {
        Project project = projectRepository.getProject(projectName);
        if(project == null) {
            System.err.println("Project not found!");
        } else {
            // Get Manger
            Manager manager = project.getManager();
            // Get employees
            List<Employee> employees = project.getEmployees();
            System.out.println("Information of the project team members:");
            System.out.println("+---+--------------------+------------------------------+----------+");
            System.out.printf("|%-3s|%-20s|%-30s|%-10s|\n", "ID", "Fullname", "Email", "Position");
            System.out.println("+---+--------------------+------------------------------+----------+");

            if(manager == null) {
                System.out.println("There is no manager in this project!");
            } else {
                System.out.printf("|%-3d|%-20s|%-30s|%-10s|\n", manager.getId(), manager.getFullName(), manager.getEmail(), "Manager");
            }

            if(employees.size() == 0) {
                System.out.println("There is no employee in this project!");
            } else {
                for (Employee employee : employees) {
                    System.out.println("+---+--------------------+------------------------------+----------+");
                    System.out.printf("|%-3s|%-20s|%-30s|%-10s|\n", employee.getId(), employee.getFullName(), employee.getEmail(), "Employee");
                }
                System.out.println("+---+--------------------+------------------------------+----------+");
            }
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        projectRepository.closeConnection();
    }
}
