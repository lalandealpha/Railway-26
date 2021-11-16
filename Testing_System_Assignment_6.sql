USE Testing_System_Assignment_1;

-- Question 1: Tạo Store để người dùng nhập vào tên phòng ban và in ra danh sách học viên của phòng ban đó.
DROP PROCEDURE IF EXISTS get_acc_info;

DELIMITER $$
CREATE PROCEDURE get_acc_info (IN dept_name VARCHAR(20))
BEGIN
	SELECT s.StudentID, s.Fullname
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

/* Question 6: Tạo 1 Store cho phép người dùng nhập vào 1 chuỗi
và trả về lớp có tên chứa chuỗi cuả người dùng nhập vào,
hoặc trả về tên học viên Username chứa chuỗi của người dùng nhập vào*/
DROP PROCEDURE IF EXISTS Find_string;

DELIMITER $$
CREATE PROCEDURE Find_string (IN string_var VARCHAR(50))
BEGIN
	SELECT c.ClassName
    FROM Class c
    WHERE c.ClassName LIKE 'CONCAT(%, string_var, %)'
    
    UNION
    
    SELECT sa.Fullname
    FROM StudentAccount sa
    WHERE sa.Username LIKE 'CONCAT(%, string_var, %)';
END $$
DELIMITER ;

CALL Find_string ('a');

/* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ
Sau đó in ra kết quả tạo thành công*/

SUBSTRING_INDEX(email_var, '@', 1)

