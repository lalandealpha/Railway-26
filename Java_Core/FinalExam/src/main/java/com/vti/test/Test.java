package com.vti.test;

import com.vti.backend.service.IProjectService;
import com.vti.backend.service.ProjectService;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
    static JdbcUtils jdbcUtils;
    static ScannerUtils scannerUtils;

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
//        jdbcUtils = new JdbcUtils();
//        scannerUtils = new ScannerUtils();
//        jdbcUtils.connectToDb("/Users/user/Code/FinalExam/src/main/source/database.properties");
//        System.out.println("Connect success!");
//        System.out.println("Try inputting an integer!");
//        int i = scannerUtils.inputInt("You did not enter an integer");
//        System.out.println(i);

        IProjectService projectService = new ProjectService();
        projectService.getProject("Project3");
    }
}
