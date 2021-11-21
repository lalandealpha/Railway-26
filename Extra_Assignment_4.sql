DROP DATABASE IF EXISTS TS_Extra_4;
CREATE DATABASE TS_Extra_4;
USE TS_Extra_4;

-- Question 1: Tạo bảng với các ràng buộc.
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	Department_no TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Department_name VARCHAR(30) UNIQUE
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
	Emp_no SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Emp_name VARCHAR(50),
    Department_no TINYINT UNSIGNED,
FOREIGN KEY (Department_no) REFERENCES Department (Department_no) ON DELETE SET NULL
);

DROP TABLE IF EXISTS Emp_skill;
CREATE TABLE Emp_skill (
	Emp_no SMALLINT UNSIGNED,
    Skill_code VARCHAR(20),
    Registered_date DATE,
FOREIGN KEY (Emp_no) REFERENCES Employee (Emp_no) ON DELETE CASCADE
);

-- Question 2: Thêm ít nhất 10 records vào mỗi bảng.
insert into Department (Department_name) values ('Product Management');
insert into Department (Department_name) values ('Support');
insert into Department (Department_name) values ('Human Resources');
insert into Department (Department_name) values ('Business Development');
insert into Department (Department_name) values ('Marketing');
insert into Department (Department_name) values ('Sales');
insert into Department (Department_name) values ('Training');
insert into Department (Department_name) values ('Engineering');
insert into Department (Department_name) values ('Accounting');
insert into Department (Department_name) values ('Services');
insert into Department (Department_name) values ('Not yes assigned');
insert into Employee (Emp_name, Department_no) values ('Fan Newrick', 9);
insert into Employee (Emp_name, Department_no) values ('Arther Slyvester', 10);
insert into Employee (Emp_name, Department_no) values ('Willabella Douch', 4);
insert into Employee (Emp_name, Department_no) values ('Philipa Lunbech', 3);
insert into Employee (Emp_name, Department_no) values ('Donnie Vaudrey', 8);
insert into Employee (Emp_name, Department_no) values ('Minette Berryann', 2);
insert into Employee (Emp_name, Department_no) values ('Sheelagh Ashburne', 4);
insert into Employee (Emp_name, Department_no) values ('Stanly Mattsson', 7);
insert into Employee (Emp_name, Department_no) values ('Chas Keelan', 10);
insert into Employee (Emp_name, Department_no) values ('Darell Gosneye', 7);
insert into Employee (Emp_name, Department_no) values ('Lianna Spurden', 2);
insert into Employee (Emp_name, Department_no) values ('Orel Wrates', 4);
insert into Employee (Emp_name, Department_no) values ('Bary Charrett', 7);
insert into Employee (Emp_name, Department_no) values ('Tomaso Romanin', 8);
insert into Employee (Emp_name, Department_no) values ('Johan Kestian', 9);
insert into Employee (Emp_name, Department_no) values ('Elisa Briiginshaw', 8);
insert into Employee (Emp_name, Department_no) values ('Cornie Frears', 6);
insert into Employee (Emp_name, Department_no) values ('Zorine Waymont', 5);
insert into Employee (Emp_name, Department_no) values ('Lonna Gillie', 4);
insert into Employee (Emp_name, Department_no) values ('Domingo Brookhouse', 3);
insert into Employee (Emp_name, Department_no) values ('Carine Brunone', 9);
insert into Employee (Emp_name, Department_no) values ('Emory Paffot', 8);
insert into Employee (Emp_name, Department_no) values ('Rosco Tabert', 7);
insert into Employee (Emp_name, Department_no) values ('Brittne Jagielski', 9);
insert into Employee (Emp_name, Department_no) values ('Pandora Burley', 2);
insert into Employee (Emp_name, Department_no) values ('Haskel Addess', 8);
insert into Employee (Emp_name, Department_no) values ('Reggie Vittery', 6);
insert into Employee (Emp_name, Department_no) values ('Karissa Yarnold', 5);
insert into Employee (Emp_name, Department_no) values ('Binny Beaby', 7);
insert into Employee (Emp_name, Department_no) values ('Corri Middleton', 4);
insert into Employee (Emp_name, Department_no) values ('Mirilla Jesper', 8);
insert into Employee (Emp_name, Department_no) values ('Catherin Kemmons', 10);
insert into Employee (Emp_name, Department_no) values ('Eal Aslum', 8);
insert into Employee (Emp_name, Department_no) values ('Ynes Reyna', 9);
insert into Employee (Emp_name, Department_no) values ('Alane Hawkeswood', 7);
insert into Employee (Emp_name, Department_no) values ('Fidelity Duiged', 3);
insert into Employee (Emp_name, Department_no) values ('Cele Plait', 8);
insert into Employee (Emp_name, Department_no) values ('Barnebas Fripp', 8);
insert into Employee (Emp_name, Department_no) values ('Teddy Messitt', 9);
insert into Employee (Emp_name, Department_no) values ('Orella Scholcroft', 8);
insert into Employee (Emp_name, Department_no) values ('Berky Crew', 8);
insert into Employee (Emp_name, Department_no) values ('Danice Francais', 10);
insert into Employee (Emp_name, Department_no) values ('Marge Bewshaw', 6);
insert into Employee (Emp_name, Department_no) values ('Myriam Anstey', 5);
insert into Employee (Emp_name, Department_no) values ('Drusilla Martland', 1);
insert into Employee (Emp_name, Department_no) values ('Cathrin Grim', 4);
insert into Employee (Emp_name, Department_no) values ('Brion Van der Hoven', 1);
insert into Employee (Emp_name, Department_no) values ('Maxim Knoble', 6);
insert into Employee (Emp_name, Department_no) values ('Pearce Howels', 4);
insert into Employee (Emp_name, Department_no) values ('Rebe Tynemouth', 6);
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (9, 'Java', '2020-11-29');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (1, 'SQL', '2021-01-20');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (44, 'Python', '2020-12-27');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (42, 'Java', '2021-07-22');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (13, 'Java', '2021-07-06');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (21, 'Java', '2021-10-24');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (4, 'Java', '2021-11-10');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (24, 'SQL', '2021-09-21');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (39, 'SQL', '2021-03-16');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (42, 'C++', '2021-02-25');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (7, 'PHP', '2021-03-11');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (11, 'Swift', '2021-09-23');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (7, 'Swift', '2021-09-18');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (26, 'C++', '2021-10-11');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (49, 'Java', '2021-07-07');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (41, 'Javascript', '2021-02-24');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (41, 'C++', '2021-09-26');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (30, 'C++', '2021-01-29');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (49, 'PHP', '2020-12-08');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (35, 'PHP', '2021-05-13');
insert into Emp_skill (Emp_no, Skill_code, Registered_date) values (7, 'Java', '2020-12-08');
-- Question 3: Viết lệnh lấy danh sách nhân viên (name) có skill Java
SELECT e.Emp_name AS Employee_name
FROM Employee e
JOIN Emp_skill es
ON e.Emp_no = es.Emp_no
WHERE es.Skill_code = 'Java';

-- Question 4: Viết lệnh lấy ra danh sách phòng ban có trên 3 nhân viên.
SELECT d.Department_name
FROM Department d
JOIN Employee e
ON d.Department_no = e.Department_no
GROUP BY d.Department_name
HAVING COUNT(e.Emp_no) > 3;

-- Question 5: Viết lệnh lấy ra danh sách nhân viên mỗi phòng ban.
SELECT d.*, e.Emp_no, e.Emp_name
FROM Department d
LEFT JOIN Employee e
ON d.Department_no = e.Department_no
ORDER BY Department_no;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có trên 1 skill.
SELECT e.Emp_no, e.Emp_name, CONCAT(COUNT(Skill_code), ' skills registerd') AS Number_of_skill
FROM Employee e
JOIN Emp_skill es
ON e.Emp_no = es.Emp_no
GROUP BY e.Emp_no
HAVING COUNT(Skill_code) > 1
ORDER BY COUNT(Skill_code) DESC;
