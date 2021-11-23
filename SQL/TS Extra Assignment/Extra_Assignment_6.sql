DROP DATABASE IF EXISTS Project_monitering;
CREATE DATABASE Project_monitering;
USE Project_monitering;

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
	EmployeeID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeLastName VARCHAR(20) NOT NULL,
    EmployeeFirstName VARCHAR(30) NOT NULL,
    EmployeeHireDate DATE NOT NULL,
    EmployeeStatus BIT,
    SupervisorID SMALLINT UNSIGNED,
    SocialSecurityNumber BIGINT UNSIGNED,
FOREIGN KEY (SupervisorID) REFERENCES Employee (EmployeeID)
);

DROP TABLE IF EXISTS Projects;
CREATE TABLE Projects (
	ProjectID SMALLINT UNSIGNED PRIMARY KEY,
    ManagerID SMALLINT UNSIGNED UNIQUE,
    ProjectName VARCHAR(100) NOT NULL,
    ProjectStartDate DATE NOT NULL,
    ProjectDescription TEXT,
    ProjectDetail TEXT,
    ProjectCompletedOn DATE,								-- Ngày hoàn thành Project
FOREIGN KEY (ManagerID) REFERENCES Employee (EmployeeID)
);

DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE Project_Modules (
	ModuleID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectID SMALLINT UNSIGNED,
    EmployeeID SMALLINT UNSIGNED,
    ProjectModulesDate DATE NOT NULL,						-- Ngày nhân viên hoàn thành Module theo kế hoạch
    Pr
);












