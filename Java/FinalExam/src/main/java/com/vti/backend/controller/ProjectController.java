package com.vti.backend.controller;

import com.vti.backend.service.IProjectService;
import com.vti.backend.service.ProjectService;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectController {
    IProjectService projectService;
    ScannerUtils scannerUtils;

    public ProjectController () throws SQLException, IOException, ClassNotFoundException {
        projectService = new ProjectService();
        scannerUtils = new ScannerUtils();
    }

    public void getProject() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Enter the project name:");
        String projectName = scannerUtils.inputString();
        projectService.getProject(projectName);
    }

    public void closeConnection() throws SQLException {
        projectService.closeConnection();
    }
}
