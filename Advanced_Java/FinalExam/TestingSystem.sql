-- Drop the database if it already exists
DROP DATABASE IF EXISTS Java_Advanced_Final_Exam;
-- Create database
CREATE DATABASE IF NOT EXISTS Java_Advanced_Final_Exam;
USE Java_Advanced_Final_Exam;

-- Create table Department
DROP TABLE IF EXISTS 	`Department`;
CREATE TABLE IF NOT EXISTS `Department` (
	DepartmentId 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	DepartmentName 			NVARCHAR(50) NOT NULL UNIQUE KEY,
    TotalMember				INT	UNSIGNED,
    DepartmentType			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL,
    CreateDate				DATETIME DEFAULT NOW()
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
	`Password` 				VARCHAR(800) NOT NULL,
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,
    `Role` 					ENUM('Admin','Employee','Manager') NOT NULL DEFAULT 'Employee',
    DepartmentID 			INT UNSIGNED NOT NULL,
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID)
);

-- =============================================
-- INSERT DATA 
-- =============================================
-- Add data Department
INSERT INTO Department(	DepartmentName, TotalMember, DepartmentType, 	CreateDate) 
VALUES
						(N'Marketing'	, 		1,		'Dev', 			'2020-03-05'),
						(N'Sale'		, 		2,		'Test', 		'2020-03-05'),
						(N'Security'	, 		3,		'ScrumMaster', 	'2020-03-07'),
						(N'HR'			, 		4,		'PM', 			'2020-03-08'),
						(N'Kỹ thuật'	, 		5,		'Dev', 			'2020-03-10'),
						(N'Tài chính'	, 		6,		'ScrumMaster', 	NOW()		),
						(N'Phó giám đốc', 		7,		'PM', 			NOW()		),
						(N'Giám đốc'	, 		8,		'Test', 		'2020-04-07'),
						(N'Thư kí'		, 		9,		'PM', 			'2020-04-07'),
						(N'Bán hàng'	, 		1,		'Dev', 			'2020-04-09');
                    
-- Add data Account
-- Password: 123456
INSERT INTO `Account`(	Username		,						`Password`									,	FirstName	,	LastName	,		`Role`		,	DepartmentID	)
VALUES 				(	'dangblack'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Hai Dang'	,		'ADMIN'		,		'5'			),
					(	'quanganh'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Quang Anh'	,		'MANAGER'	,		'1'			),
                    (	'vanchien'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Van Chien'	,		'ADMIN'		,		'1'			),
                    (	'cocoduongqua'	,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Co Co'		,		'EMPLOYEE'	,		'1'			),
                    (	'doccocaubai'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Doc Co'	,		'ADMIN'		,		'2'			),
                    (	'khabanh'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan'		,	'Kha Bang'	,		'EMPLOYEE'	,		'2'			),
                    (	'huanhoahong'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Van Huan'	,		'ADMIN'		,		'2'			),
                    (	'tungnui'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Tung Nui'	,		'MANAGER'	,		'8'			),
                    (	'duongghuu'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan'		,	'Duong Huu'	,		'ADMIN'		,		'9'			),
                    (	'vtiaccademy'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Academy'	,		'MANAGER'	,		'10'		);