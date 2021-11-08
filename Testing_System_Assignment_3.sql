DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

CREATE TABLE Department (
	DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	DepartmentName VARCHAR(50) NOT NULL  UNIQUE KEY
);

CREATE TABLE `Position` (
	PositionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	PositionName ENUM ('Admin', 'Mentor', 'Student') NOT NULL UNIQUE KEY
);
 
CREATE TABLE StudentAccount (
	StudentID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR (50),
	Username VARCHAR (50) NOT NULL UNIQUE KEY,
	Fullname VARCHAR (50),
	DepartmentID TINYINT UNSIGNED,
	PositionID TINYINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID),
FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID)
);

CREATE TABLE TeacherAccount (
	TeacherID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR (50),
	Username VARCHAR (50) NOT NULL UNIQUE KEY,
	Fullname VARCHAR (50),
	DepartmentID TINYINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID)
);

CREATE TABLE Class (
	ClassID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	ClassName VARCHAR (50) NOT NULL UNIQUE KEY,
	CreatorID SMALLINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (CreatorID) REFERENCES TeacherAccount (TeacherID)
);

CREATE TABLE ClassAccount (
	ClassID TINYINT UNSIGNED,
	StudentID SMALLINT UNSIGNED,
	JoinDate DATE,
FOREIGN KEY (ClassID) REFERENCES Class (ClassID),
FOREIGN KEY (StudentID) REFERENCES StudentAccount (StudentID)
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
FOREIGN KEY (TypeID) REFERENCES QuestionType (TypeID),
FOREIGN KEY (CategoryID) REFERENCES QuestionCategory (CategoryID),
FOREIGN KEY (CreatorID) REFERENCES TeacherAccount (TeacherID)
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
    Timelimit TIME NOT NULL,
	CategoryID TINYINT UNSIGNED,
	CreatorID SMALLINT UNSIGNED,
	CreateDate DATE,
FOREIGN KEY (CategoryID) REFERENCES QuestionCategory (CategoryID),
FOREIGN KEY (CreatorID) REFERENCES TeacherAccount (TeacherID)
);

CREATE TABLE ExamQuestion (
	ExamID SMALLINT UNSIGNED,
	QuestionID SMALLINT UNSIGNED,
FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

-- Question 1: Thêm record vào tất cả các table
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
	('teacher2@gmail.com', 'teacher22', 'TEACHER22', 1, 20180520),
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
    ('How is the weather today?', 2, 2, 3, 20210826);

INSERT INTO Answer (Content, QuestionID, isCorrect) VALUES
	('DZXDEGSEF', 1, 'False'),
	('SELECT * FROM table_name', 2, 'True'),
    ('Today is a new day to learn somthing', 3, 'False'),
    ('Today is rainy', 3, 'True'),
    ('Its rainy', 3, 'True'),
    ('No, today is hot', 3, 'False'),
    ('Well, good morning', 3, 'False');

INSERT INTO Exam (`Code`, Title, Timelimit, CategoryID, CreatorID, CreateDate) VALUES
	(4778, 'First Exam', '00:60:00', 2, 4, 20201216),
	(2685, 'Second Exam', '00:45:00', 6, 3, 20210514),
    (233, 'Third Exam', '00:90:00', 1, 2, 20190720),
    (9853, 'Mini Exam', '00:15:00', 5, 4, 20200308);

INSERT INTO ExamQuestion (ExamID, QuestionID) VALUES
	(1, 1),
	(2, 2);
    
-- Question 2: Lấy ra tất cả các phòng ban
SELECT * FROM Department;

-- Question 3: Lấy ra ID phòng ban IT
SELECT DepartmentId FROM Department
WHERE DepartmentName = 'IT';

-- Question 4: Lấy ra thông tin TeacherAccount có Fullname dài nhất (cách 1)
SELECT * FROM TeacherAccount
ORDER BY LENGTH(Fullname) DESC
LIMIT 1;

-- Question 4: Lấy ra thông tin TeacherAccount có Fullname dài nhất (cách 2)
SELECT * FROM TeacherAccount
WHERE Fullname = (SELECT MAX(Fullname) FROM TeacherAccount);

-- Question 5: Lấy ra thông tin TeacherAccount có Fullname dài nhất và thuộc phòng ban có ID bằng 1
SELECT * FROM TeacherAccount
WHERE Fullname = (SELECT MAX(Fullname) FROM TeacherAccount WHERE DepartmentID = 1);

-- Question 6: Lấy ra tên lớp đã lập trước ngày 30/22/2021
SELECT ClassName FROM Class
WHERE CreateDate < 20211230;

-- Question 7: Lấy ra ID của Question có ít nhất 4 Answers
SELECT QuestionID, COUNT(AnswerID) FROM Answer 
GROUP BY QuestionID HAVING COUNT(AnswerID) >= 4;

-- Question 8: Lấy ra các mã Exam có Timelimit ít nhất 60 phút và tạo trước ngày 01/04/2020
SELECT Code FROM Exam
WHERE Timelimit >= '00:60:00' AND CreateDate < 20200401;

-- Question 9: Lấy ra 5 lớp đã lập gần đây nhất
SELECT * FROM Class
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: Đếm số giáo viên thuộc phòng ban có ID là 2
SELECT COUNT(TeacherID) FROM TeacherAccount 
WHERE DepartmentID = 2;

-- Question 11: Lấy ra thông tin giáo viên có Fullname bắt đầu bằng T và kết thúc b
SELECT * FROM TeacherAccount
WHERE Fullname LIKE 'T%6';

-- Question 12: Xoá tất cả các Exam tạo trước ngày 31/12/2019
DELETE FROM Exam WHERE CreateDate < 20191231;

-- Question 13: Xoá tất cả các Question có nội dung bắt đầu bằng "ABC"
DELETE FROM Question WHERE Content LIKE 'ABC%';

-- Question 14: Update thông tin của Student có ID là 5 thành tên "Nguyen Thanh Luan" và email "luan@vti.com.vn"
UPDATE StudentAccount SET
Fullname = 'Nguyen Thanh Luan',
Email = 'luan@vti.com.vn'
WHERE StudentID = 5;

-- Question 15: Update khoa của học sinh có ID là 3 thành khoa Marketing
UPDATE StudentAccount SET
DepartmentID = (SELECT DepartmentID FROM Department WHERE DepartmentName = 'Marketing')
WHERE StudentID = 3;

SELECT * FROM StudentAccount;