DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

CREATE TABLE Department (
	DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	DepartmentName VARCHAR(50) NOT NULL  UNIQUE KEY
);

CREATE TABLE `Position` (
	PositionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	PositionName ENUM ('Admin', 'Mentor', 'Student', 'Leader', 'Vice Monitor', 'Secretary') NOT NULL UNIQUE KEY
);
 
CREATE TABLE StudentAccount (
	StudentID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR (50),
	Username VARCHAR (50) NOT NULL UNIQUE KEY,
	Fullname VARCHAR (50),
	DepartmentID TINYINT UNSIGNED,
	PositionID TINYINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID) ON DELETE CASCADE,
FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID) ON DELETE CASCADE
);

CREATE TABLE TeacherAccount (
	TeacherID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR (50),
	Username VARCHAR (50) NOT NULL UNIQUE KEY,
	Fullname VARCHAR (50),
	DepartmentID TINYINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID) ON DELETE CASCADE
);

CREATE TABLE Class (
	ClassID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	ClassName VARCHAR (50) NOT NULL UNIQUE KEY,
	CreatorID SMALLINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (CreatorID) REFERENCES TeacherAccount (TeacherID) ON DELETE CASCADE
);

CREATE TABLE ClassAccount (
	ClassID TINYINT UNSIGNED,
	StudentID SMALLINT UNSIGNED,
	JoinDate DATE,
FOREIGN KEY (ClassID) REFERENCES Class (ClassID),
FOREIGN KEY (StudentID) REFERENCES StudentAccount (StudentID) ON DELETE CASCADE
);

CREATE TABLE QuestionType (
	TypeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	TypeName ENUM ('Essay', 'Multiple-Choice')
);

CREATE TABLE QuestionCategory (
	CategoryID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	CategoryName VARCHAR (50) NOT NULL UNIQUE KEY
);

CREATE TABLE Question (
	QuestionID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content VARCHAR (200) NOT NULL,
	CategoryID TINYINT UNSIGNED,
	TypeID TINYINT UNSIGNED,
	CreatorID SMALLINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (TypeID) REFERENCES QuestionType (TypeID) ON DELETE CASCADE,
FOREIGN KEY (CategoryID) REFERENCES QuestionCategory (CategoryID) ON DELETE CASCADE,
FOREIGN KEY (CreatorID) REFERENCES TeacherAccount (TeacherID) ON DELETE CASCADE
);

CREATE TABLE Answer (
	AnswerID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
	Content VARCHAR (200) NOT NULL,
	QuestionID SMALLINT UNSIGNED,
	isCorrect ENUM ('True','False'),
FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID) ON DELETE CASCADE
);

CREATE TABLE Exam (
	ExamId SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`Code` SMALLINT NOT NULL,
	Title VARCHAR (50) NOT NULL,
	`Duration(Mins)` TINYINT NOT NULL,
	CategoryID TINYINT UNSIGNED,
	CreatorID SMALLINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (CategoryID) REFERENCES QuestionCategory (CategoryID) ON DELETE CASCADE,
FOREIGN KEY (CreatorID) REFERENCES TeacherAccount (TeacherID) ON DELETE CASCADE
);

CREATE TABLE ExamQuestion (
	ExamID SMALLINT UNSIGNED,
	QuestionID SMALLINT UNSIGNED,
FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID) ON DELETE CASCADE
);

-- Question 1: Th??m record v??o t???t c??? c??c table
INSERT INTO Department (DepartmentName) VALUES
	('Japanese'),
	('English'),
	('IT'),
	('French'),
	('Chinese'),
	('Marketing'),
	('Korean'),
	('Finance'),
	('Economics'),
	('Biology');

INSERT INTO `Position` (PositionName) VALUES
	('Admin'),
	('Mentor'),
	('Student');

INSERT INTO StudentAccount (Email, Username, Fullname, DepartmentID, PositionID, CreateDate) VALUES
	('abc@gmail.com', 'abc', 'ABC ', 3, 2, 20211101),
	('defz@gmail.com', 'defZ', 'DEFZ TEN DEMO', 1, 1, 20211101),
	('ghk@gmail.com', 'ghk', 'GHK DAI NHAT', 3, 3, 20211101),
	('vti@gmail.com', 'vti', 'VTI', 1, 2, 20211101),
	('xyz@gmail.com', 'xyz', 'XYZ DAI', 2, 3, 20211101);

INSERT INTO TeacherAccount (Email, Username, Fullname, DepartmentID, CreateDate) VALUES
	('teacher1@gmail.com', 'teacher1', 'TEACHER1', 1, 20171130),
	('teacher2@gmail.com', 'teacher22', 'TEACHER22', 4, 20180520),
	('teacher3@gmail.com', 'teacher333', 'TEACHER333', 3, 20181003),
	('teacher4@gmail.com', 'teacher4444', 'TEACHER4444', 2, 20181210),
	('teacher5@gmail.com', 'teacher55555', 'TEACHER55555', 3, 20190727),
	('teacher6@gmail.com', 'teacher666', 'TEACHER666', 5, 20191120),
	('teacher7@gmail.com', 'teacher777777777', 'TEACHER777777777', 2, 20200401),
	('teacher8@gmail.com', 'teacher888888', 'TEACHER888888', 2, 20200401);

INSERT INTO Class (ClassName, CreatorID, CreateDate) VALUES
	('JAP1', 2, 20211107),
	('ENG10', 4, 20201130),
	('RAILWAY26', 3, 20220507),
	('FRE3', 5, 20181107),
	('MAR11', 1, 20190218),
	('ECO47', 2, 20210221),
	('BIO69', 4, 20200328);

INSERT INTO ClassAccount (ClassID, StudentID, JoinDate) VALUES
	(1, 2, 20211107),
	(1, 4, 20211107),
	(2, 5, 20211107),
	(3, 1, 20211107),
	(3, 1, 20211107);

INSERT INTO QuestionType (TypeName) VALUES
	('Essay'),
	('Multiple-Choice');

INSERT INTO QuestionCategory (CategoryName) VALUES
	('General knowledge'),
	('Vocabulary'),
	('Grammar'),
	('Listening'),
	('Writting'),
	('Programing');

INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate) VALUES
	('ABCD GHIJK?', 2, 2, 4, 20211030),
	('Use SELECT Syntax to query data from some tables', 6, 1, 5, 20211015),
	('How is the weather today?', 2, 2, 3, 20210826),
	('UDISK KSAJNGS?', 5, 1, 2, 20200622),
	('HKUSDHSKDF?', 1, 2, 7, 20191103),
	('Set fire to the rain?', 6, 1, 8, 20211109);

INSERT INTO Answer (Content, QuestionID, isCorrect) VALUES
	('DZXDEGSEF', 1, 'False'),
	('SELECT * FROM table_name', 2, 'True'),
	('Today is a new day to learn somthing', 3, 'False'),
	('Today is rainy', 3, 'True'),
	('Its rainy', 3, 'True'),
	('No, today is hot', 3, 'False'),
	('Well, good morning', 3, 'False'),
	('SELECT FROM ABC', 2, 'False'),
	('Nothing is impossible', 2, 'True'),
	('Here are some answers', 2, 'False');

INSERT INTO Exam (`Code`, Title, `Duration(Mins)`, CategoryID, CreatorID, CreateDate) VALUES
	(4778, 'First Exam', 60, 2, 4, 20201216),
	(2685, 'Second Exam', 45, 6, 3, 20210514),
	(233, 'Third Exam', 90, 1, 2, 20190720),
	(9853, 'Mini Exam', 15, 5, 4, 20200308);

INSERT INTO ExamQuestion (ExamID, QuestionID) VALUES
	(1, 1),
	(1, 4),
	(1, 5),
	(2, 1),
	(2, 3),
	(2, 4),
	(3, 2),
	(3, 3),
	(3, 5),
	(3, 6),
	(4, 2);
    
-- Th??m r??ng bu???c on delete cho c??c b???ng.
ALTER TABLE StudentAccount
DROP CONSTRAINT `studentaccount_ibfk_1`;
ALTER TABLE StudentAccount
ADD CONSTRAINT `studentaccount_ibfk_1` FOREIGN KEY (`PositionID`) REFERENCES `Position` (`PositionID`) ON DELETE SET NULL;

ALTER TABLE StudentAccount
DROP CONSTRAINT `studentaccount_ibfk_2`;
ALTER TABLE StudentAccount
ADD CONSTRAINT `studentaccount_ibfk_2` FOREIGN KEY (`DepartmentID`) REFERENCES `Department` (`DepartmentID`) ON DELETE SET NULL;

ALTER TABLE TeacherAccount
DROP CONSTRAINT `teacheraccount_ibfk_1`;
ALTER TABLE TeacherAccount
ADD CONSTRAINT `teacheraccount_ibfk_1` FOREIGN KEY (`DepartmentID`) REFERENCES `Department` (`DepartmentID`) ON DELETE SET NULL;

ALTER TABLE Class
DROP CONSTRAINT  `class_ibfk_1`;
ALTER TABLE Class
ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`CreatorID`) REFERENCES `TeacherAccount` (`TeacherID`) ON DELETE SET NULL;

ALTER TABLE ClassAccount
DROP CONSTRAINT `classaccount_ibfk_1`;
ALTER TABLE ClassAccount
ADD CONSTRAINT `classaccount_ibfk_1` FOREIGN KEY (`ClassID`) REFERENCES `Class` (`ClassID`) ON DELETE CASCADE;
ALTER TABLE ClassAccount
DROP CONSTRAINT `classaccount_ibfk_2`;
ALTER TABLE ClassAccount
ADD CONSTRAINT `classaccount_ibfk_2` FOREIGN KEY (`StudentID`) REFERENCES `StudentAccount` (`StudentID`) ON DELETE SET NULL;

ALTER TABLE Question
DROP CONSTRAINT `question_ibfk_1`;
ALTER TABLE Question
ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`TypeID`) REFERENCES `QuestionType` (`TypeID`) ON DELETE SET NULL;
ALTER TABLE Question
DROP CONSTRAINT `question_ibfk_2`;
ALTER TABLE Question
ADD CONSTRAINT `question_ibfk_2` FOREIGN KEY (`CategoryID`) REFERENCES `QuestionCategory` (`CategoryID`) ON DELETE SET NULL;
ALTER TABLE Question
DROP CONSTRAINT `question_ibfk_3`;
ALTER TABLE Question
ADD CONSTRAINT `question_ibfk_3` FOREIGN KEY (`CreatorID`) REFERENCES `TeacherAccount` (`TeacherID`) ON DELETE CASCADE;

ALTER TABLE Answer
DROP CONSTRAINT `answer_ibfk_1`;
ALTER TABLE Answer
ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`QuestionID`) REFERENCES `Question` (`QuestionID`) ON DELETE CASCADE;

ALTER TABLE Exam
DROP CONSTRAINT `exam_ibfk_1`;
ALTER TABLE Exam
ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `QuestionCategory` (`CategoryID`) ON DELETE SET NULL;
ALTER TABLE Exam
DROP CONSTRAINT `exam_ibfk_2`;
ALTER TABLE Exam
ADD CONSTRAINT `exam_ibfk_2` FOREIGN KEY (`CreatorID`) REFERENCES `TeacherAccount` (`TeacherID`) ON DELETE CASCADE;

ALTER TABLE ExamQuestion
DROP CONSTRAINT `examquestion_ibfk_1`;
ALTER TABLE ExamQuestion
ADD CONSTRAINT `examquestion_ibfk_1` FOREIGN KEY (`ExamID`) REFERENCES `Exam` (`ExamId`) ON DELETE CASCADE;
ALTER TABLE ExamQuestion
DROP CONSTRAINT `examquestion_ibfk_2`;
ALTER TABLE ExamQuestion
ADD CONSTRAINT `examquestion_ibfk_2` FOREIGN KEY (`QuestionID`) REFERENCES `Question` (`QuestionID`) ON DELETE SET NULL;
/*
-- Question 2: L???y ra t???t c??? c??c ph??ng ban
SELECT * FROM Department;

-- Question 3: L???y ra ID ph??ng ban IT
SELECT DepartmentId FROM Department
WHERE DepartmentName = 'IT';

-- Question 4: L???y ra th??ng tin gi??o vi??n c?? Fullname d??i nh???t (c??ch 1)
SELECT * FROM TeacherAccount
ORDER BY LENGTH(Fullname) DESC
LIMIT 1;

-- Question 4: L???y ra th??ng tin gi??o vi??n c?? Fullname d??i nh???t (c??ch 2)
SELECT * FROM TeacherAccount;
SELECT max(length(Fullname)) FROM TeacherAccount;
SELECT * 
FROM TeacherAccount
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM TeacherAccount);

-- Question 5: L???y ra th??ng tin gi??o vi??n c?? Fullname d??i nh???t v?? thu???c ph??ng ban c?? ID b???ng 3
SELECT MAX(LENGTH(Fullname))
FROM TeacherAccount
WHERE DepartmentID = 3;

SELECT * FROM TeacherAccount
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM TeacherAccount WHERE DepartmentID = 3);

-- Question 6: L???y ra t??n l???p ???? l???p tr?????c ng??y 30/12/2020
SELECT ClassName FROM Class
WHERE CreateDate < 20201230;

-- Question 7: L???y ra ID c???a c??c c??u h???i c?? ??t nh???t 4 c??u tr??? l???i
SELECT QuestionID FROM Answer 
GROUP BY QuestionID HAVING COUNT(AnswerID) >= 4;

-- Question 7: L???y ra ID c???a c??c c??u h???i c?? ??t nh???t 4 c??u tr??? l???i (k??m theo s??? c??u tr??? l???i)
SELECT QuestionID, COUNT(AnswerID) FROM Answer 
GROUP BY QuestionID HAVING COUNT(AnswerID) >= 4;

-- Question 8: L???y ra c??c m?? b??i thi c?? th???i gian ??t nh???t 60 ph??t v?? t???o tr?????c ng??y 01/04/2021
SELECT `Code` FROM Exam
WHERE `Duration(Mins)` >= 60 AND CreateDate < 20210401;

-- Question 9: L???y ra 5 l???p ???? l???p g???n ????y nh???t
SELECT * FROM Class
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: ?????m s??? gi??o vi??n thu???c ph??ng ban ti???ng Anh 
SELECT COUNT(TeacherID) FROM TeacherAccount 
WHERE DepartmentID = (SELECT DepartmentID FROM Department WHERE DepartmentName = 'English');

-- Question 11: L???y ra th??ng tin gi??o vi??n c?? Fullname b???t ?????u b???ng "T" v?? k???t th??c b???ng "6"
SELECT * FROM TeacherAccount
WHERE Fullname LIKE 'T%6';

-- Question 12: Xo?? t???t c??? c??c b??i ki???m tra t???o tr?????c ng??y 31/12/2019
DELETE FROM Exam WHERE CreateDate < 20191231;

-- Question 13: Xo?? t???t c??? c??c c??u h???i c?? n???i dung b???t ?????u b???ng "ABC"
DELETE FROM Question WHERE Content LIKE 'ABC%';

-- Question 14: Update th??ng tin c???a h???c sinh c?? ID l?? 5 th??nh t??n "Nguyen Thanh Luan" v?? Email "luan@vti.com.vn"
UPDATE StudentAccount SET
Fullname = 'Nguyen Thanh Luan',
Email = 'luan@vti.com.vn'
WHERE StudentID = 5;

-- Question 15: Update khoa c???a h???c sinh c?? ID l?? 3 th??nh khoa Marketing
UPDATE StudentAccount SET
DepartmentID = (SELECT DepartmentID FROM Department WHERE DepartmentName = 'Marketing')
WHERE StudentID = 3;

SELECT * FROM StudentAccount;
*/