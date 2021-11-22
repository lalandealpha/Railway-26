CREATE DATABASE Testing_System_Assignment_1;

USE Testing_System_Assignment_1;

CREATE TABLE Department (
DepartmentID INT PRIMARY KEY AUTO_INCREMENT,
DepartmentName VARCHAR(50)
);

CREATE TABLE Position (
PositionID INT PRIMARY KEY AUTO_INCREMENT,
PositionName VARCHAR (50)
);

CREATE TABLE Account(
AccountID INT PRIMARY KEY AUTO_INCREMENT,
Email VARCHAR (50),
Username VARCHAR (50),
Fullname VARCHAR (50),
DepartmentID INT,
PositionID INT,
CreateDate DATE
);

CREATE TABLE `Group` (
GroupID INT PRIMARY KEY AUTO_INCREMENT,
GroupName VARCHAR (50),
CreatorID INT,
CreateDate DATE
);

CREATE TABLE GroupAccount (
GroupID INT,
AccountID INT,
JoinDate DATE
);

CREATE TABLE TypeQuestion (
TypeID INT PRIMARY KEY AUTO_INCREMENT,
TypeName VARCHAR (50)
);

CREATE TABLE CategoryQuestion (
CategoryID INT PRIMARY KEY AUTO_INCREMENT,
CategoryName VARCHAR (50)
);

CREATE TABLE Question (
QuestionID INT PRIMARY KEY AUTO_INCREMENT,
Content VARCHAR (200),
CategoryID INT,
TypeID INT,
CreatorID INT,
CreateDate DATE
);

CREATE TABLE Answer (
AnswerID INT PRIMARY KEY AUTO_INCREMENT,
Content VARCHAR (200),
QuestionID INT,
isCorrect VARCHAR (50)
);

CREATE TABLE Exam (
ExamId INT PRIMARY KEY AUTO_INCREMENT,
`Code` INT,
Title VARCHAR (50),
CategoryID INT,
CreatorID INT,
CreateDate DATE
);

CREATE TABLE ExamQuestion (
ExamID INT,
QuestionID INT
);