DROP DATABASE IF EXISTS JavaFinalExam;
CREATE DATABASE JavaFinalExam;
USE JavaFinalExam;

DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin` (
	AdminId SMALLINT UNSIGNED PRIMARY KEY,
	Email VARCHAR(50) NOT NULL,
	Fullname VARCHAR(50),
    `Password` VARCHAR(50) NOT NULL
);

INSERT INTO `Admin` (AdminId, Email, Fullname, `Password`) VALUES
(1, 'tspringtorp0@telegraph.co.uk', 'Tedie Springtorp', 'kxPkEkroL8yE'),
(2, 'aferron2@shared.com', 'Alexia Ferron', '3Hl5jHrO');

DROP TABLE IF EXISTS Project;
CREATE TABLE Project (
    ProjectId INT UNSIGNED PRIMARY KEY,
    ProjectName VARCHAR(30)
);

INSERT INTO Project (ProjectId, ProjectName)
VALUES (1, 'Project1'),
       (2, 'Project2'),
       (3, 'Project3');

DROP TABLE IF EXISTS Manager;
CREATE TABLE Manager (
    ManagerId SMALLINT UNSIGNED PRIMARY KEY,
    Email VARCHAR(50) NOT NULL,
    Fullname VARCHAR(50),
    `Password` VARCHAR(50) NOT NULL,
    ExpInYear TINYINT UNSIGNED,
    ProjectId INT UNSIGNED,
FOREIGN KEY (ProjectId) REFERENCES Project (ProjectId) ON DELETE SET NULL
);

INSERT INTO `Manager` (ManagerId, Email, Fullname, `Password`, ExpInYear, ProjectId) VALUES
(3, 'dtritton0@sphinn.com', 'Dionis Tritton', 'W4CQwKgEBXmu', 5, 1),
(4, 'ashakesbye1@mlb.com', 'Arv Shakesbye', '7pHdvvnNcrs', 3, 2),
(5, 'rivanchenkov7@admin.ch', 'Rick Ivanchenkov', 'Gq2HqB53', 1, 3);

DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
	EmployeeId SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Email VARCHAR(50) NOT NULL,
	Fullname VARCHAR(50),
    `Password` VARCHAR(50) NOT NULL,
    ProSkill VARCHAR(10),
    ProjectId INT UNSIGNED,
FOREIGN KEY (ProjectId) REFERENCES Project (ProjectId) ON DELETE SET NULL
);
ALTER TABLE `Employee` AUTO_INCREMENT = 10;
INSERT INTO `Employee` (Email, Fullname, `Password`, ProSkill, ProjectId) VALUES
('agrigoriev3@mit.edu', 'Alexine Grigoriev', 'NhcHDfwh1Fr', 'dev', 1),
('vloding4@jalbum.net', 'Virgie Loding', '0ij17u20mh', 'java', 1),
('adurtnall9@etsy.com', 'Alexis Durtnall', 'Jg5nRYo0ZaMO', 'sql', 3),
('fcandlin7@army.mil', 'Farlie Candlin', '6B6peju', 'python', 3),
('kkingdonl@toplist.cz', 'Kevyn Kingdon', 'VPNoqY', 'c++', 2);

SELECT * FROM Admin;
SELECT * FROM Employee;
SELECT * FROM Manager;
SELECT * FROM Project;