USE Testing_System_Assignment_1;

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
-- Cách 2
SELECT Question.Content 
FROM ExamQuestion 
INNER JOIN Question ON Question.QuestionID = ExamQuestion.QuestionID
GROUP BY ExamQuestion.QuestionID
HAVING COUNT(ExamQuestion.QuestionID) =	(SELECT MAX(query1) 
										FROM
											(SELECT COUNT(ExamQuestion.QuestionID) AS query1 
											FROM ExamQuestion GROUP BY ExamQuestion.QuestionID) AS query2);
-- Cách 3, sử dụng View
DROP VIEW IF EXISTS Exam_count;

CREATE VIEW Exam_count AS
SELECT COUNT(ExamQuestion.QuestionID) AS Ex_count
FROM ExamQuestion 
GROUP BY ExamQuestion.QuestionID;

SELECT Question.Content
FROM ExamQuestion
INNER JOIN Question 
ON Question.QuestionID = ExamQuestion.QuestionID
GROUP BY ExamQuestion.QuestionID
HAVING COUNT(ExamQuestion.QuestionID) = (SELECT MAX(Ex_count) FROM Exam_count);

-- Question 6: Thống kê mỗi Chủ đề câu hỏi được sử dụng bao nhiêu lần tương ứng với các câu hỏi theo thứ tự tăng dần
SELECT
	QuestionCategory.CategoryName,
    COUNT(Question.QuestionID) AS QuestionCount
FROM Question
LEFT JOIN QuestionCategory
ON Question.CategoryID = QuestionCategory.CategoryID
GROUP BY QuestionCategory.CategoryName
ORDER BY QuestionCount;

-- Question 7: Thống kê mỗi Câu hỏi được sử dụng trong bao nhiêu bài thi
SELECT
	Question.Content AS Question_Content,
    COUNT(ExamQuestion.ExamID) AS Count_of_exams
FROM ExamQuestion
RIGHT JOIN Question
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

-- Question 11: Thống kê mỗi lớp có bao nhiêu Admin, Mentor, Student
-- Trường hợp yêu cầu tất cả các lớp kể cả các lớp không có thành viên nào
SELECT
	Class.ClassName,
	Position.PositionName,
    COUNT(ClassAccount.StudentID)
FROM Class
LEFT JOIN ClassAccount
ON Class.ClassID = ClassAccount.ClassID
LEFT JOIN StudentAccount
ON ClassAccount.StudentID = StudentAccount.StudentID
LEFT JOIN `Position`
ON StudentAccount.PositionID = `Position`.PositionID
GROUP BY Class.ClassName, Position.PositionName;
-- Trường hợp chỉ thống kê các lớp có thành viên (hoặc sử dụng INNER JOIN)
SELECT
	Class.ClassName,
	Position.PositionName,
    COUNT(ClassAccount.StudentID)
FROM Class, ClassAccount, StudentAccount, `Position`
WHERE Class.ClassID = ClassAccount.ClassID
AND ClassAccount.StudentID = StudentAccount.StudentID
AND StudentAccount.PositionID = `Position`.PositionID
GROUP BY Class.ClassName, Position.PositionName;

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
