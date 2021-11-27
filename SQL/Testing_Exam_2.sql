DROP DATABASE IF EXISTS Testing_Exam_2;
CREATE DATABASE Testing_Exam_2;
USE Testing_Exam_2;

DROP TABLE IF EXISTS departments;
CREATE TABLE departments (
	id INT(10) PRIMARY KEY,
    `name` VARCHAR(30) NOT NULL,
    `description` TEXT,
    created_at DATETIME NOT NULL,
    updated_at DATETIME
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
	id INT(10) PRIMARY KEY,
	first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    employee_id VARCHAR(10),
    avatar TEXT,
    department_id INT(10),
    gender TINYINT(10),
    age INT(3),
    created_at DATETIME,
    updated_at DATETIME
);

DROP TABLE IF EXISTS user_department;
CREATE TABLE user_department (
	id INT(10) PRIMARY KEY,
	user_id INT(10) NOT NULL,
    department_id INT(10) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    created_at DATETIME,
    updated_at DATETIME,
FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
FOREIGN KEY (department_id) REFERENCES departments (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
	id INT(10) PRIMARY KEY,
    `name` VARCHAR(30) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
	id INT(10) PRIMARY KEY,
    user_department_id INT(10) NOT NULL,
    role_id INT(10),
    start_date DATE,
    end_date DATE,
    created_at DATETIME,
    updated_at DATETIME,
FOREIGN KEY (user_department_id) REFERENCES user_department (id) ON DELETE CASCADE,
FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE SET NULL
);

DROP TABLE IF EXISTS salary;
CREATE TABLE salary (
	id INT(10) PRIMARY KEY,
    user_role_id INT(10) NOT NULL,
    total_salary DOUBLE(12,2) NOT NULL,
    `month` VARCHAR(2),
    `year` VARCHAR(4),
    created_at DATETIME,
    updated_at DATETIME,
FOREIGN KEY (user_role_id) REFERENCES user_role (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS salary_detail_type;
CREATE TABLE salary_detail_type (
	id INT(10) PRIMARY KEY,
    `name` VARCHAR(10) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME
);

DROP TABLE IF EXISTS salary_detail;
CREATE TABLE salary_detail (
	id INT(10) PRIMARY KEY,
    amount DOUBLE(12,2),
    salary_id INT(10),
    salary_detail_type_id INT(10),
    operation TINYINT(3),
FOREIGN KEY (salary_id) REFERENCES salary (id) ON DELETE CASCADE,
FOREIGN KEY (salary_detail_type_id) REFERENCES salary_detail_type (id) ON DELETE SET NULL
);

/* Question 2: Viết procedure cho phép nhập vào tên user, năm, tháng để in ra fullname kèm theo lương tháng đó.
Chú ý: 1 user có thể có 2 role trong cùng 1 tháng, nhận theo 2 salary.id */
DROP PROCEDURE IF EXISTS p_get_user_salary;
DELIMITER $$
CREATE PROCEDURE p_get_user_salary (IN in_full_name VARCHAR(100), IN in_year VARCHAR(4), IN in_month VARCHAR(2))
BEGIN
	SELECT CONCAT(u.first_name, ' ',u.last_name) AS full_name, SUM(s.total_salary) AS salary_in_month
	FROM users u
	JOIN user_department ud
	ON u.id = ud.user_id
	JOIN user_role ur
	ON ur.user_department_id = ud.id
	JOIN salary s
	ON s.user_role_id = ur.id
	WHERE s.`year` = in_year
	AND s.`month` = in_month
	AND CONCAT(u.first_name, ' ',u.last_name) = in_full_name
	GROUP BY full_name;
END $$
DELIMITER ;

CALL p_get_user_salary('Sidonia Peter', '2020', '5');

-- Question 3: Viết procedure in ra danh sách lương tháng sắp xếp giảm dần của phòng và tháng, năm mà người dùng nhập vào.
DROP PROCEDURE IF EXISTS p_salary_by_department;
DELIMITER $$
CREATE PROCEDURE p_salary_by_department (IN in_dept_name VARCHAR(30), IN in_year VARCHAR(4), IN in_month VARCHAR(2))
BEGIN
	SELECT u.id, CONCAT(u.first_name, ' ', u.last_name) AS full_name, SUM(s.total_salary) AS salary_in_month
	FROM users u
	JOIN user_department ud
	ON ud.user_id = u.id
	JOIN departments d
	ON d.id = ud.department_id
	JOIN user_role ur
	ON ur.user_department_id = ud.id
	JOIN salary s
	ON s.user_role_id = ur.id
	WHERE d.`name` = in_dept_name
	AND s.`year` = in_year
	AND s.`month` = in_month
	GROUP BY u.id, full_name
	ORDER BY salary_in_month DESC;
END $$
DELIMITER ;

CALL p_salary_by_department('HR', '2020', '6');

-- Question 4: Viết procedure lấy ra những user bị tính lương sai theo tháng mà người dùng nhập vào.
DROP PROCEDURE IF EXISTS p_get_incorrect_salary;
DELIMITER $$
CREATE PROCEDURE p_get_incorrect_salary (IN in_year VARCHAR(4), IN in_month VARCHAR(2))
BEGIN
	SET @correct_net_salary = 	(SELECT SUM(get_amount) FROM								-- Tổng số lương cơ bản, phụ cấp (operation = 1)
														(SELECT sd.amount AS get_amount
														FROM salary_detail sd, salary s
														WHERE s.`year` = in_year
														AND s.`month` = in_month
														AND operation = 1) AS subquery1) 
							- 
								(SELECT SUM(get_amount) FROM								-- Tổng số khấu trừ thuế, bảo hiểm (operation = 2)
														(SELECT sd.amount AS get_amount
														FROM salary_detail sd, salary s
														WHERE s.`year` = in_year
														AND s.`month` = in_month
														AND operation = 2) AS subquery2);

	SELECT DISTINCT u.id, CONCAT(u.first_name, ' ', u.last_name) AS full_name				-- So sánh lương ghi trong bảng salary và giá trị trên.
	FROM users u
	JOIN user_department ud
	ON ud.user_id = u.id
	JOIN departments d
	ON d.id = ud.department_id
	JOIN user_role ur
	ON ur.user_department_id = ud.id
	JOIN salary s
	ON s.user_role_id = ur.id
	WHERE s.`year` = in_year
	AND s.`month` = in_month
	AND s.total_salary != @correct_net_salary;
END $$
DELIMITER ;

CALL p_get_incorrect_salary('2020', '5');

-- Question 5: Tính tổng chi phí của từng phòng.
SELECT d.`name`, SUM(s.total_salary) AS total_salary_by_dept
FROM departments d 
LEFT JOIN user_department ud
ON d.id = ud.department_id 
LEFT JOIN users u
ON ud.user_id = u.id
LEFT JOIN user_role ur
ON ur.user_department_id = ud.id
LEFT JOIN salary s
ON s.user_role_id = ur.id
GROUP BY d.`name`
ORDER BY total_salary_by_dept DESC;

-- Question 6: 

/* Question 7: Viết thủ tục cho phép get lương tháng của 1 user bất kì hiển thị thông tin sau: 
fullname (first_name + last_name), department, role, salary*/
DROP PROCEDURE IF EXISTS p_get_user_salary_v2;
DELIMITER $$
CREATE PROCEDURE p_get_user_salary_v2 (IN in_full_name VARCHAR(100), IN in_year VARCHAR(4), IN in_month VARCHAR(2))
BEGIN
	SELECT CONCAT(u.first_name, ' ',u.last_name) AS full_name, s.total_salary AS salary, d.`name` AS department, r.`name` AS role
	FROM users u
	JOIN user_department ud
	ON u.id = ud.user_id
	JOIN user_role ur
	ON ur.user_department_id = ud.id
	JOIN salary s
	ON s.user_role_id = ur.id
    JOIN roles r
    ON ur.role_id = r.id
    JOIN departments d
    ON d.id = ud.department_id
	WHERE s.`year` = in_year
	AND s.`month` = in_month
	AND CONCAT(u.first_name, ' ',u.last_name) = in_full_name;
END $$
DELIMITER ;

CALL p_get_user_salary_v2 ('Sidonia Peter', '2020', '5');
