package com.vti.backend.repository;

import com.vti.entity.Project;

import java.io.IOException;
import java.sql.SQLException;

public interface IProjectRepository {
    Project getProject(String projectName) throws SQLException, IOException, ClassNotFoundException;
    void closeConnection() throws SQLException;
}
