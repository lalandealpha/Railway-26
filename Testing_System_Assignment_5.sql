USE Testing_System_Assignment_1;

SET SQL_SAFE_UPDATES = 0;

-- Question 1: Tạo view có chứa danh sách giáo viên thuộc ban tiếng Anh.
DROP VIEW IF EXISTS Eng_teacher_view;

CREATE VIEW Eng_teacher_view AS
SELECT ta.TeacherID, ta.Username, ta.Fullname
FROM TeacherAccount ta
JOIN Department da
ON da.DepartmentID = ta.DepartmentID
WHERE da.DepartmentName = 'English';

SELECT * FROM Eng_teacher_view;

-- Question 2: Lấy ra câu hỏi có nhiều câu trả lời nhất, sử dụng view thay cho subquery.
DROP VIEW IF EXISTS Ques_count_view;

CREATE VIEW Ques_count_view AS
SELECT COUNT(a.QuestionID) AS No_of_ques
FROM Answer a
GROUP BY a.QuestionID;

SELECT q.QuestionID, q.Content, COUNT(a.QuestionID)
FROM Question q
JOIN Answer a
ON q.QuestionID = a.QuestionID
GROUP BY a.QuestionID
HAVING COUNT(a.QuestionID) = (SELECT MAX(No_of_ques) FROM Ques_count_view);

-- Question 3: Tạo view có chứa câu hỏi nội dung trên 30 kí tự và xoá nó đi.
ALTER TABLE Question 
ALTER COLUMN QuestionID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT ON DELETE CASCADE; -- Gặp lỗi cú pháp?!?

DROP VIEW IF EXISTS Ques_morethan20Char_view;

CREATE VIEW Ques_morethan20Char_view AS
SELECT * FROM Question
WHERE LENGTH(Content) > 30;

DELETE FROM Ques_morethan20Char_view;

-- Question 4: Tạo view chứa danh sách phòng ban có nhiều giáo viên nhất.
DROP VIEW IF EXISTS TeacherCount_view;

CREATE VIEW TeacherCount_view AS
SELECT COUNT(t.TeacherID) AS No_of_teacher
FROM TeacherAccount t
JOIN Department d
ON d.DepartmentID = t.DepartmentID
GROUP BY t.DepartmentID;

DROP VIEW IF EXISTS MaxTeacherCount_dep_view;

CREATE VIEW MaxTeacherCount_dep_view AS
SELECT d.DepartmentID, d.DepartmentName
FROM Department d
JOIN TeacherAccount t
ON d.DepartmentID = t.DepartmentID
GROUP BY t.DepartmentID
HAVING COUNT(t.TeacherID) = (SELECT MAX(No_of_teacher) FROM TeacherCount_view);

SELECT * FROM MaxTeacherCount_dep_view;

-- Question 5: Tạo view chứa tất cả các câu hỏi do giáo viên có họ NGUYEN tạo.
DROP VIEW IF EXISTS Ques_by_NGUYEN_view;

CREATE VIEW Ques_by_NGUYEN_view AS
SELECT q.QuestionID, q.Content
FROM Question q
JOIN TeacherAccount t
ON q.CreatorID = t.TeacherID
WHERE SUBSTRING_INDEX(t.Fullname,' ',1) = 'NGUYEN';

SELECT * FROM Ques_by_NGUYEN_view;

