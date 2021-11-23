DROP DATABASE IF EXISTS Project_monitering;
CREATE DATABASE Project_monitering;
USE Project_monitering;

-- Question 1: Tạo bảng với các ràng buộc, insert record.
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
	EmployeeID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeLastName VARCHAR(20) NOT NULL,
    EmployeeFirstName VARCHAR(30) NOT NULL,
    EmployeeHireDate DATE NOT NULL,
    EmployeeStatus BIT NOT NULL DEFAULT 0,										-- Giả định: 0 là đang làm việc, 1 là đã nghỉ việc
    SupervisorID SMALLINT UNSIGNED,
    SocialSecurityNumber BIGINT UNSIGNED,
FOREIGN KEY (SupervisorID) REFERENCES Employee (EmployeeID)
);

DROP TABLE IF EXISTS Projects;
CREATE TABLE Projects (
	ProjectID SMALLINT UNSIGNED PRIMARY KEY,
    ManagerID SMALLINT UNSIGNED,
    ProjectName VARCHAR(100) NOT NULL,
    ProjectStartDate DATE NOT NULL,
    ProjectDescription TEXT,
    ProjectDetail TEXT,
    ProjectCompletedOn DATE,													-- Ngày hoàn thành Project
FOREIGN KEY (ManagerID) REFERENCES Employee (EmployeeID) ON DELETE SET NULL
);

DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE Project_Modules (
	ModuleID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectID SMALLINT UNSIGNED NOT NULL,
    EmployeeID SMALLINT UNSIGNED,
    ProjectModulesDate DATE NOT NULL,											-- Ngày nhân viên hoàn thành Module theo kế hoạch
    ProjectModulesCompletedOn DATE,
    ProjectModulesDescription TEXT,
FOREIGN KEY (ProjectID) REFERENCES Projects (ProjectID) ON DELETE CASCADE,
FOREIGN KEY (EmployeeID) REFERENCES Employee (EmployeeID) ON DELETE SET NULL
);

DROP TABLE IF EXISTS Work_Done;
CREATE TABLE Work_Done (
	WorkDoneID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeID SMALLINT UNSIGNED,
    ModuleID INT UNSIGNED,
    WorkDoneDate DATE,
    WorkDoneDescription TEXT,
    WorkDoneStatus BIT NOT NULL,												-- Giả định 0 là chưa hoàn thành, 1 là đã hoàn thành
FOREIGN KEY (EmployeeID) REFERENCES Employee (EmployeeID) ON DELETE SET NULL,
FOREIGN KEY (ModuleID) REFERENCES Project_Modules (ModuleID) ON DELETE CASCADE
);

/* Question 2: Viết Procedure để xoá tất cả thông tin project đã hoàn thành
sau 6 tháng kể từ thời điểm hiện tại. In ra số lượng record đã removed từ các table liên quan*/
DROP PROCEDURE IF EXISTS P_Del_Project_3months_ago;
DELIMITER $$
CREATE PROCEDURE P_Del_Project_3months_ago ()
BEGIN
DELETE FROM Projects 
WHERE MONTH(NOW()) - MONTH(ProjectCompletedON) > 5;
END $$
DELIMITER ;

SELECT * FROM Projects WHERE MONTH(NOW()) - MONTH(ProjectCompletedON) > 5;
CALL P_Del_Project_3months_ago ();

-- Question 3: Viết Procedure in ra các Module đang được thực hiện.
DROP PROCEDURE IF EXISTS P_Module_in_progress;
DELIMITER $$
CREATE PROCEDURE P_Module_in_progress (IN in_projectID SMALLINT)
BEGIN
	SELECT * FROM Project_Modules
    WHERE ProjectID = in_projectID
    AND ProjectModulesCompletedOn IS NULL;
END $$
DELIMITER ;

CALL P_Module_in_progress (5012);

-- Question 4: Viết Function trả về thông tin nhân viên đã tham gia mặc dù không ai giao việc cho nhân viên đó.
SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS F_Not_Assisgned_Employee;
DELIMITER $$
CREATE FUNCTION F_Not_Assisgned_Employee (in_project SMALLINT) RETURNS VARCHAR(50)
BEGIN
	DECLARE Employee_Fullname VARCHAR(50);
		SELECT CONCAT(e.EmployeeFirstName, ' ', e.EmployeeLastName) INTO Employee_Fullname
		FROM Employee e
		JOIN Work_Done wd
		ON wd.EmployeeID = e.EmployeeID
		JOIN Project_Modules pm
		ON wd.ModuleID = pm.ModuleID
		JOIN Projects p
		ON pm.ProjectID = p.ProjectID
		WHERE p.ProjectID = in_project
        AND wd.EmployeeID != pm.EmployeeID
		LIMIT 1;
    RETURN Employee_Fullname;
END $$
DELIMITER ;

SELECT F_Not_Assisgned_Employee (5012);