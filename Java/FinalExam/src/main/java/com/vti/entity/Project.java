package com.vti.entity;

import java.util.List;

public class Project {
    private int projectId, teamSize;
    private String projectName;
    Manager manager;
    List<Employee> employees;

    public Project(int projectId, int teamSize, String projectName, Manager manager, List<Employee> employees) {
        this.projectId = projectId;
        this.teamSize = teamSize;
        this.projectName = projectName;
        this.manager = manager;
        this.employees = employees;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
