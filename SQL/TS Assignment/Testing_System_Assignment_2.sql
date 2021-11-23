DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

CREATE TABLE Department (
DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
DepartmentName VARCHAR(50) NOT NULL
);

CREATE TABLE `Position` (
PositionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
PositionName ENUM ('Dev', 'Test', 'Scrum', 'Master', 'PM') NOT NULL
);

CREATE TABLE `Account` (
AccountID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Email VARCHAR (50),
Username VARCHAR (50) NOT NULL,
Fullname VARCHAR (50),
DepartmentID TINYINT UNSIGNED,
PositionID TINYINT UNSIGNED,
CreateDate DATE,
FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID),
FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID)
);

CREATE TABLE `Group` (
GroupID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
GroupName VARCHAR (50) NOT NULL,
CreatorID SMALLINT UNSIGNED,
CreateDate DATE,
FOREIGN KEY (CreatorID) REFERENCES `Account` (AccountID)
);

CREATE TABLE GroupAccount (
GroupID TINYINT UNSIGNED,
AccountID SMALLINT UNSIGNED,
JoinDate DATE,
FOREIGN KEY (GroupID) REFERENCES `Group` (GroupID),
FOREIGN KEY (AccountID) REFERENCES `Account` (AccountID)
);

CREATE TABLE TypeQuestion (
TypeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
TypeName ENUM ('Essay', 'Multiple-Choice')
);

CREATE TABLE CategoryQuestion (
CategoryID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
CategoryName VARCHAR (50) NOT NULL
);

CREATE TABLE Question (
QuestionID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Content VARCHAR (200) NOT NULL,
CategoryID TINYINT UNSIGNED,
TypeID TINYINT UNSIGNED,
CreatorID SMALLINT UNSIGNED,
CreateDate DATE,
FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID),
FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
FOREIGN KEY (CreatorID) REFERENCES `Account` (AccountID)
);

CREATE TABLE Answer (
AnswerID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
Content VARCHAR (200) NOT NULL,
QuestionID SMALLINT UNSIGNED,
isCorrect ENUM ('True','False'),
FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

CREATE TABLE Exam (
ExamId SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`Code` SMALLINT NOT NULL,
Title VARCHAR (50) NOT NULL,
CategoryID TINYINT UNSIGNED,
CreatorID SMALLINT UNSIGNED,
CreateDate DATE,
FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
FOREIGN KEY (CreatorID) REFERENCES `Account` (AccountID)
);

CREATE TABLE ExamQuestion (
ExamID SMALLINT UNSIGNED,
QuestionID SMALLINT UNSIGNED,
FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

INSERT INTO Department (DepartmentName) VALUES
('Marketing'),
('Sale'),
('Bao ve'),
('Nhan su'),
('Ky thuat'),
('Tai chinh'),
('Pho giam doc'),
('Giam doc'),
('Thu ky'),
('Ban hang');

SELECT * FROM Department;