package com.vti.backend.service;

import com.vti.entity.Project;

import java.io.IOException;
import java.sql.SQLException;

public interface IProjectService {
    void getProject(String projectName) throws SQLException, IOException, ClassNotFoundException;
    void closeConnection() throws SQLException;
}
