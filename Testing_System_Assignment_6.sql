USE Testing_System_Assignment_1;

SET SQL_SAFE_UPDATES = 0;

-- Question 1: Tạo Store để người dùng nhập vào tên phòng ban và in ra danh sách thông tin học viên của phòng ban đó.
DROP PROCEDURE IF EXISTS get_acc_info;
DELIMITER $$
CREATE PROCEDURE get_acc_info (IN dept_name VARCHAR(20))
BEGIN
	SELECT s.*
    FROM StudentAccount s
    JOIN Department d
    ON d.DepartmentID = s.DepartmentID
    WHERE d.DepartmentName = dept_name;
END $$
DELIMITER ;

CALL get_acc_info ('IT');

-- Question 2: Tạo Store để in ra số lượng học viên lớp.
DROP PROCEDURE IF EXISTS get_stu_count;
DELIMITER $$
CREATE PROCEDURE get_stu_count (IN class_name VARCHAR(20))
BEGIN
	SELECT COUNT(ca.StudentID) AS Number_of_student
    FROM ClassAccount ca
    JOIN Class c
    ON c.ClassID = ca.ClassID
    WHERE c.ClassName = class_name;
END $$
DELIMITER ;

CALL get_stu_count ('JAP1');

-- Question 3: Tạo Store thống kê mỗi kiểu câu hỏi có bao nhiêu câu hỏi được tạo trong tháng hiện tại.
DROP PROCEDURE IF EXISTS Ques_count_in_month;
DELIMITER $$
CREATE PROCEDURE Ques_count_in_month ()
BEGIN
	SELECT qt.TypeName, COUNT(q.QuestionID)
    FROM QuestionType qt
    JOIN Question q
    ON q.TypeID = qt.TypeID
    WHERE YEAR(q.CreateDate) = YEAR(NOW()) AND MONTH(q.CreateDate) = MONTH(NOW())
    GROUP BY q.QuestionID;
END $$
DELIMITER ;

CALL Ques_count_in_month ();

-- Question 4: Tạo Store để trả ra ID của loại câu hỏi có nhiều câu trả lời nhất.
DROP PROCEDURE IF EXISTS most_answers_QuestionType;
DELIMITER $$
CREATE PROCEDURE most_answers_QuestionType(OUT Most_TypeID INT)
BEGIN
	SELECT QuestionType.TypeID INTO Most_TypeID 
	FROM QuestionType
	INNER JOIN Question
	ON Question.TypeID = QuestionType.TypeID
	INNER JOIN Answer
	ON Answer.QuestionID = Question.QuestionID
	GROUP BY Answer.QuestionID
	HAVING COUNT(Answer.QuestionID) =	(SELECT MAX(query1) 
										FROM 
										(SELECT COUNT(Answer.QuestionID) AS query1 
										FROM Answer GROUP BY Answer.QuestionID) AS query2);
END $$
DELIMITER ;
SET @most_typeID ='';
CALL most_answers_QuestionType(@most_typeID);
SELECT @most_typeID;

-- Question 5: Sử dụng Store ở câu hỏi 4 để tìm ra tên của loại câu hỏi.
SELECT QuestionType.TypeName
FROM QuestionType
WHERE QuestionType.TypeID = @most_typeID;

/* Question 6: Tạo 1 Store cho phép người dùng nhập vào 1 chuỗi và trả về lớp có tên chứa chuỗi cuả người dùng nhập vào,
hoặc trả về tên học viên Username chứa chuỗi của người dùng nhập vào*/
DROP PROCEDURE IF EXISTS Find_string;
DELIMITER $$
CREATE PROCEDURE Find_string (IN string_in VARCHAR(50))
BEGIN
	SELECT c.ClassName
    FROM Class c
    WHERE c.ClassName LIKE CONCAT('%', string_in, '%')
    
   UNION
    
	SELECT sa.Fullname
    FROM StudentAccount sa
    WHERE sa.Username LIKE CONCAT('%', string_in, '%');
END $$
DELIMITER ;

CALL Find_string ('a');

/* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin Fullname, email và trong store sẽ tự động tạo tài khoản học viên với:
- Username sẽ giống email nhưng bỏ phần @..mail đi
- PositionID: sẽ có default là student
- DepartmentID: sẽ được cho vào 1 phòng chờ
- Ngày tạo tài khoản là ngày hiện tại
Sau đó in ra kết quả tạo thành công*/
INSERT INTO Department (DepartmentName)
VALUES ('Not yet assigned'); -- Tạo một phòng chờ

DROP PROCEDURE IF EXISTS auto_create_acc;
DELIMITER $$
CREATE PROCEDURE auto_create_acc (IN fullname_in VARCHAR(50), email_in VARCHAR(50))
BEGIN
	DECLARE username_in VARCHAR(50) DEFAULT SUBSTRING_INDEX(email_in, '@', 1);
    DECLARE positionID_in VARCHAR(10) DEFAULT (SELECT PositionID FROM `Position` WHERE PositionName = 'Student');
    DECLARE departmentID_in VARCHAR(20) DEFAULT (SELECT DepartmentID FROM Department WHERE DepartmentName = 'Not yet assigned');
    
	INSERT INTO StudentAccount (Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
    VALUES (email_in, username_in, fullname_in, departmentID_in, positionID_in, CURDATE());
    
    SELECT * FROM StudentAccount
    WHERE Email = email_in;
END $$
DELIMITER ;

CALL Testing_System_Assignment_1.auto_create_acc('Nguyen ABCD', 'abcde@gmail.com');

/* Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice 
để thống kê câu hỏi Essay hoặc Multiple-choice nào có content dài nhất*/
DROP PROCEDURE IF EXISTS longest_ques;
DELIMITER $$
CREATE PROCEDURE longest_ques (IN type_in VARCHAR(20))
BEGIN
	SELECT q.QuestionID, q.Content
	FROM Question q
	JOIN QuestionType qt
	ON q.TypeID = qt.TypeID
	WHERE qt.TypeName = type_in
	AND LENGTH(q.Content) = (SELECT MAX(cont_length) FROM 	(SELECT LENGTH(Content) AS cont_length 
															FROM Question q
															JOIN QuestionType qt
															ON q.TypeID = qt.TypeID
															WHERE qt.TypeName = type_in) AS query1);
END $$
DELIMITER ;

CALL longest_ques ('Essay');
CALL longest_ques ('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID.
DROP PROCEDURE IF EXISTS Del_exam;
DELIMITER $$
CREATE PROCEDURE Del_exam (IN exID_in INT)
BEGIN
	DELETE FROM Exam WHERE ExamId = exID_in;
END $$
DELIMITER ;

CALL Del_exam (1);

/* Question 10: Tìm ra các exam được tạo từ 5 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
Sau đó in số lượng record đã remove từ các table liên quan trong khi removing*/
CREATE OR REPLACE VIEW ExamId_view AS 
SELECT ExamId
FROM Exam
WHERE YEAR(CreateDate) <=  YEAR(NOW()) - 5;

SELECT * FROM ExamId_view;

CALL Del_exam(ExamId_view);

CALL Del_exam (
	SELECT ExamId FROM Exam WHERE ExamID IN (SELECT ExamId FROM ExamId_view)
);

/* Question 11:  Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban
và các TeacherAccount thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ làm việc*/
DROP PROCEDURE IF EXISTS Del_department;
DELIMITER $$
CREATE PROCEDURE Del_Department (IN dep_name_in VARCHAR(20))
BEGIN
	UPDATE TeacherAccount ta
	JOIN Department d
	ON ta.DepartmentID = d.DepartmentID
	SET ta.DepartmentID = (SELECT DepartmentID FROM Department WHERE DepartmentName = 'Not yet assigned')
	WHERE d.DepartmentName = dep_name_in;
    
    DELETE FROM Department WHERE DepartmentName = dep_name_in;
END $$
DELIMITER ;

CALL Del_department ('Chinese');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo.
DROP PROCEDURE IF EXISTS Ques_count_on_month;
DELIMITER $$
CREATE PROCEDURE Ques_count_on_month ()
BEGIN
	CREATE OR REPLACE VIEW 12months_list_view AS					-- Tạo 1 view chứa 12 tháng của năm nay.
		SELECT CONCAT(YEAR(NOW()), '-', '01') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '02') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '03') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '04') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '05') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '06') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '07') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '08') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '09') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '10') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '11') AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', '12') AS YearMonth;

	CREATE OR REPLACE VIEW this_year_ques_view AS					-- Tạo 1 view chứa câu hỏi được tạo trong năm nay.
	SELECT * FROM Question WHERE YEAR(CreateDate) = YEAR(NOW());
    
	SELECT m.*, COUNT(ty.QuestionID) AS Number_of_questions			-- Left Join view câu hỏi vào view 12 tháng.
	FROM `12months_list_view` m
	LEFT JOIN this_year_ques_view ty
	ON MONTH(ty.CreateDate) = SUBSTRING_INDEX(m.YearMonth, '-', -1)
	GROUP BY YearMonth;
END $$
DELIMITER ;

CALL Ques_count_on_month;

/* Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
(Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")*/
-- Hàm DATE_SUB cho ra kết quả 6 tháng gần nhất
DROP PROCEDURE IF EXISTS Ques_count_on_6months;
DELIMITER $$
CREATE PROCEDURE Ques_count_on_6months ()
BEGIN
	CREATE OR REPLACE VIEW `6months_from_now_view` AS													-- Tạo view chứa 6 tháng trong năm nay.
		SELECT CONCAT(YEAR(NOW()), '-', MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH))) AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH))) AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH))) AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH))) AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH))) AS YearMonth UNION
		SELECT CONCAT(YEAR(NOW()), '-', MONTH(NOW())) AS YearMonth;

	CREATE OR REPLACE VIEW this_year_ques_view AS														-- Tạo view chứa câu hỏi trong năm nay.
	SELECT * FROM Question WHERE YEAR(CreateDate) = YEAR(NOW());
    
	SELECT m.*, COUNT(ty.QuestionID) AS Number_of_questions												-- Left Join view câu hỏi vào view 6 tháng.
	FROM `6months_from_now_view` m
	LEFT JOIN this_year_ques_view ty
	ON MONTH(ty.CreateDate) = SUBSTRING_INDEX(m.YearMonth, '-', -1)
	GROUP BY YearMonth;
    
END $$
DELIMITER ;

CALL Ques_count_on_6months;
