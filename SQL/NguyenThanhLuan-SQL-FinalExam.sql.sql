DROP DATABASE IF EXISTS Student_management;
CREATE DATABASE Student_management;
USE Student_management;

-- Question 1: Tạo table với các ràng buộc và thêm ít nhất 3 bản ghi vào mỗi table
DROP TABLE IF EXISTS Student;
CREATE TABLE Student (
	ID CHAR(10) PRIMARY KEY,							-- Giả định ID của học sinh bao gồm 10 chữ và số.
    `Name` VARCHAR(50) NOT NULL,
    Age TINYINT UNSIGNED,
    Gender BIT											-- Giả định 0 là Male, 1 là Female, NULL là chưa rõ.
);

INSERT INTO Student VALUES 
('A120100001', 'Nguyen Thanh Luan', 16, 0),
('B220121035', 'Nguyen The An', 18, 0),
('C320112301', 'Hoang Thi Thanh', 17, 1),
('D420121568', 'Tran Vien', 18, NULL);

DROP TABLE IF EXISTS `Subject`;
CREATE TABLE `Subject` (
	ID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(30) NOT NULL
);

INSERT INTO `Subject` (`Name`) VALUES
('Maths'),
('Information technology'),
('English');

DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE StudentSubject (
	StudentID CHAR(10),
    SubjectID TINYINT UNSIGNED,
    Mark ENUM('A', 'B', 'C', 'D', 'E', 'F'),
    `Date` DATE,
PRIMARY KEY (StudentID, SubjectID),
FOREIGN KEY (StudentID) REFERENCES Student (ID) ON DELETE CASCADE,
FOREIGN KEY (SubjectID) REFERENCES `Subject` (ID) ON DELETE CASCADE
);

INSERT INTO StudentSubject VALUES
('A120100001', 2, 'B', 20130330),
('B220121035', 2, 'A', 20130212),
('B220121035', 1, 'D', 20121020),
('D420121568', 2, 'C', 20130822);

-- Question 2a: Lấy tất cả các môn học không có bất kỳ điểm nào.
SELECT DISTINCT s.`Name` AS Subject_name
FROM `Subject` s
LEFT JOIN StudentSubject ss
ON s.ID = ss.SubjectID
WHERE ss.Mark IS NULL;

-- Question 2b: Lấy ra danh sách môn học có ít nhất 2 điểm.
SELECT s.`Name` AS SubjectName
FROM `Subject` s
JOIN StudentSubject ss
ON s.ID = ss.SubjectID
GROUP BY SubjectName
HAVING COUNT(ss.Mark) >= 2;

/* Question 3: Tạo View có tên là StudentInfo lấy các thông tin của học sinh bao gồm:
StudentID, SubjectID, Student Name, Student Age, Student Gender, Subject Name, Mark, Date
(Với cột Gender show 'Male' để thay thế cho 0, 'Female' thay thế cho 1 và 'Unknown' thay thế cho null)*/
CREATE OR REPLACE VIEW StudentInfo AS
SELECT
	st.ID AS StudentID,
    sj.ID AS SubjectID,
    st.`Name` AS StudentName,
    st.Age AS StudentAge,
	CASE	WHEN st.Gender = 0 THEN 'Male'
			WHEN st.Gender = 1 THEN 'Female'
			ELSE 'Unknown'
	END AS StudentGender,
    sj.`Name` AS SubjectName,
    ss.Mark,
    ss.`Date`
FROM Student st
LEFT JOIN StudentSubject ss
ON st.ID = ss.StudentID
LEFT JOIN `Subject` sj
ON sj.ID = ss.SubjectID;

SELECT * FROM StudentInfo;

/* Viết 1 store procedure (có 2 parameters: student name) sẽ 
xóa tất cả các thông tin liên quan tới học sinh có cùng tên như parameter
Trong trường hợp nhập vào student name = "*" thì procedure sẽ xóa tất cả các học sinh.*/
DROP PROCEDURE IF EXISTS p_del_stud_info;
DELIMITER $$
CREATE PROCEDURE p_del_stud_info (IN in_student_name VARCHAR (50))
BEGIN
	SET SQL_SAFE_UPDATES = 0;
    IF in_student_name = '*' THEN
	DELETE FROM Student;
    ELSE
    DELETE FROM Student WHERE `Name` = in_student_name;
    END IF;
END $$
DELIMITER ; 

SELECT * FROM Student;

CALL p_del_stud_info('Nguyen Thanh Luan');
CALL p_del_stud_info('*');

    









