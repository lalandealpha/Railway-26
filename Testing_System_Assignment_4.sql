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
	`Duration(Mins)` TINYINT NOT NULL,
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
	(4, 3, 20211107),
    (4, 2, 20210227);

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
    (1, 3),
    (1, 2),
	(2, 1),
	(2, 3),
	(2, 4),
	(3, 2),
	(3, 3),
	(3, 5),
	(3, 6),
	(4, 2);
    
-- Question 1: Lấy ra danh sách học viên và phòng ban của họ
SELECT 
	StudentAccount.StudentID,
	StudentAccount.Fullname AS StudentName,
	Department.DepartmentName
FROM StudentAccount
JOIN Department 
ON StudentAccount.DepartmentID = Department.DepartmentID;

-- Question 2: Lấy ra thông tin account giáo viên được tạo sau ngày 01/12/2018
SELECT
	TeacherAccount.*,
	Department.DepartmentName
FROM TeacherAccount
JOIN Department
ON TeacherAccount.DepartmentID = Department.DepartmentID
WHERE TeacherAccount.CreateDate > 20181201;

-- Question 3: Lấy ra thông tin của tất cả Mentor
SELECT
	StudentAccount.*,
	`Position`.PositionName
FROM StudentAccount
JOIN `Position`
ON StudentAccount.PositionID = `Position`.PositionID
WHERE PositionName = 'Mentor';

-- Question 4: Lấy ra danh sách phòng ban có trên 2 giáo viên
SELECT Department.DepartmentName
FROM Department
JOIN TeacherAccount
ON TeacherAccount.DepartmentID = Department.DepartmentID
GROUP BY Department.DepartmentName
HAVING COUNT(TeacherAccount.TeacherID) > 2;

-- Question 5: Lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
-- Trước hết, đưa ra danh sách câu hỏi kèm theo thống kê số lượng bài thi nó được sử dụng
SELECT
	Question.Content AS Question_Content,
	COUNT(ExamQuestion.ExamID) AS Count_of_exams
FROM ExamQuestion
JOIN Question
ON ExamQuestion.QuestionID = Question.QuestionID
GROUP BY Question.Content;
-- Viết câu lệnh đáp ứng yêu cầu câu hỏi:
SELECT query1.Question_Content
FROM
	(SELECT
		Question.Content AS Question_Content,
        COUNT(ExamQuestion.ExamID) AS Count_of_exams
	FROM ExamQuestion
    JOIN Question
    ON ExamQuestion.QuestionID = Question.QuestionID
    GROUP BY Question.Content) AS query1,
    
    (SELECT MAX(query2.Count_of_exams) AS Highest_count
	FROM
		(SELECT
			Question.Content AS Question_Content,
            COUNT(ExamQuestion.ExamID) AS Count_of_exams
            FROM ExamQuestion
            JOIN Question
            ON ExamQuestion.QuestionID = Question.QuestionID
            GROUP BY Question.Content) AS query2) AS query3
WHERE query1.Count_of_exams = query3.Highest_count;

-- Question 6: Thống kê mỗi Chủ đề câu hỏi được sử dụng bao nhiêu lần tương ứng với các câu hỏi theo thứ tự tăng dần
SELECT
	QuestionCategory.CategoryName,
    COUNT(Question.QuestionID) AS QuestionCount
FROM Question
JOIN QuestionCategory
ON Question.CategoryID = QuestionCategory.CategoryID
GROUP BY QuestionCategory.CategoryName
ORDER BY QuestionCount;

-- Question 7: Thống kê mỗi Câu hỏi được sử dụng trong bao nhiêu bài thi
SELECT
	Question.Content AS Question_Content,
	COUNT(ExamQuestion.ExamID) AS Count_of_exams
FROM ExamQuestion
JOIN Question
ON ExamQuestion.QuestionID = Question.QuestionID
GROUP BY Question.Content;

-- Question 8: Lấy ra câu hỏi có nhiều câu trả lời nhất
-- Tương tự câu 5, trước hết lấy ra các câu hỏi kèm theo số lượng câu trả lời
SELECT
	Question.Content AS Question_Content,
    COUNT(Answer.AnswerID)
FROM Question
JOIN Answer
ON Question.QuestionID = Answer.QuestionID
GROUP BY Question.Content;
-- Viết câu lệnh đáp ứng yêu cầu câu hỏi:
SELECT query1.Question_Content
FROM
	(SELECT
		Question.Content AS Question_Content,
		COUNT(Answer.AnswerID) AS Answer_Count
		FROM Question
		JOIN Answer
		ON Question.QuestionID = Answer.QuestionID
		GROUP BY Question.Content) AS query1,
	
	(SELECT MAX(query2.Answer_Count) AS Highest_Count
	FROM 
		(SELECT
			Question.Content AS Question_Content,
			COUNT(Answer.AnswerID) AS Answer_Count
			FROM Question
			JOIN Answer
			ON Question.QuestionID = Answer.QuestionID
			GROUP BY Question.Content) AS query2) AS query3
WHERE query1.Answer_Count = query3.Highest_Count;
        
-- Question 9: Thống kê số lượng học viên trong mỗi lớp
SELECT
	Class.ClassName,
	COUNT(ClassAccount.StudentID) AS Number_of_students
FROM Class
LEFT JOIN ClassAccount
ON Class.ClassID = ClassAccount.ClassID
GROUP BY Class.ClassName;

-- Question 10: Tìm chức vụ có ít người nhất
-- Tương tự câu 5, trước hết liệt kê từng vị trí kèm theo số lượng học viên
SELECT
	`Position`.PositionName AS Position,
	COUNT(StudentAccount.StudentID) AS StudentCount
FROM `Position`
JOIN StudentAccount
ON StudentAccount.PositionID = `Position`.PositionID
GROUP BY `Position`.PositionName;
-- Viết câu lệnh đưa ra yêu cầu của đề bài:
SELECT query1.*
FROM 
	(SELECT
		`Position`.PositionName AS Position,
		COUNT(StudentAccount.StudentID) AS StudentCount
		FROM `Position`
		JOIN StudentAccount
		ON StudentAccount.PositionID = `Position`.PositionID
		GROUP BY `Position`.PositionName) AS query1,
	
    (SELECT MIN(query2.StudentCount) AS LowestCount
	FROM 
		(SELECT
		`Position`.PositionName AS Position,
		COUNT(StudentAccount.StudentID) AS StudentCount
		FROM `Position`
		JOIN StudentAccount
		ON StudentAccount.PositionID = `Position`.PositionID
		GROUP BY `Position`.PositionName) AS query2) AS query3
WHERE query1.StudentCount = query3.LowestCount;

-- Question 11: Thống kê mỗi lớp có bao nhiêu Admin, Mentor, Student -> chưa nghĩ ra
SELECT
	Class.ClassName,
	Position.PositionName
FROM Class
LEFT JOIN ClassAccount
ON Class.ClassID = ClassAccount.ClassID
LEFT JOIN StudentAccount
ON ClassAccount.StudentID = StudentAccount.StudentID
LEFT JOIN `Position`
ON StudentAccount.PositionID = `Position`.PositionID;

-- Question 12: Lấy ra thông tin chi tiết (tất cả thông tin liên quan) của các câu hỏi
SELECT
	Question.QuestionID,
    Question.Content,
    QuestionType.TypeName AS `Type`,
    QuestionCategory.CategoryName AS Category,
    TeacherAccount.Fullname AS Creator,
    Exam.Title AS Exam,
    Answer.Content AS Answer,
    Answer.isCorrect
FROM Question
JOIN QuestionType
ON Question.TypeID = QuestionType.TypeID
JOIN QuestionCategory
ON Question.CategoryID = QuestionCategory.CategoryID
JOIN TeacherAccount
ON Question.CreatorID = TeacherAccount.TeacherID
JOIN ExamQuestion
ON ExamQuestion.QuestionID = Question.QuestionID
JOIN Exam
ON ExamQuestion.ExamID = Exam.ExamID
JOIN Answer
ON Answer.QuestionID = Question.QuestionID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT
	QuestionType.TypeName AS QuestionType,
    COUNT(Question.QuestionID)
FROM QuestionType
LEFT JOIN Question
ON Question.TypeID = QuestionType.TypeID
GROUP BY QuestionType.TypeName;

-- Question 14,15: Lấy ra khoa không có lớp học nào
SELECT DISTINCT 
	Department.DepartmentName
FROM Department
LEFT JOIN StudentAccount
ON StudentAccount.DepartmentID = Department.DepartmentID
LEFT JOIN ClassAccount
On StudentAccount.StudentID = ClassAccount.StudentID
WHERE ClassAccount.ClassID IS NULL;

-- Question 16: Lấy ra câu hỏi không có câu trả lời nào
-- Cách 1:
SELECT Question.Content AS Question
FROM Question
LEFT JOIN Answer
ON Answer.QuestionID = Question.QuestionID
WHERE Answer.Content IS NULL;
-- Cách 2:
SELECT Question.Content AS Question
FROM Question
LEFT JOIN Answer
ON Answer.QuestionID = Question.QuestionID
GROUP BY Question.QuestionID
HAVING COUNT(Answer.AnswerID) = 0;

-- Question 17: Lấy ra các học viên thuộc lớp số 2 và lớp số 4, ghép lại sao cho không record nào trùng nhau
SELECT StudentAccount.Fullname AS StudentName
FROM StudentAccount
JOIN ClassAccount
ON ClassAccount.StudentID = StudentAccount.StudentID
WHERE ClassAccount.ClassID = 2
UNION
SELECT StudentAccount.Fullname AS StudentName
FROM StudentAccount
JOIN ClassAccount
ON ClassAccount.StudentID = StudentAccount.StudentID
WHERE ClassAccount.ClassID = 4;

-- Question 18: Lấy ra các khoa có nhiều hơn 2 giáo viên, và các khoa có nhiều ít hơn 4 giáo viên, sau đó ghép lại
SELECT Department.DepartmentName AS Department
FROM Department
JOIN TeacherAccount
ON TeacherAccount.DepartmentID = Department.DepartmentID
GROUP BY Department.DepartmentName
HAVING COUNT(TeacherAccount.TeacherID) >2
UNION ALL
SELECT Department.DepartmentName AS Department
FROM Department
JOIN TeacherAccount
ON TeacherAccount.DepartmentID = Department.DepartmentID
GROUP BY Department.DepartmentName
HAVING COUNT(TeacherAccount.TeacherID) <4;
