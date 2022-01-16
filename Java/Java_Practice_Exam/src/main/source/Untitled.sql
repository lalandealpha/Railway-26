DROP DATABASE IF EXISTS UserManagement;
CREATE DATABASE UserManagement;
USE UserManagement;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
	Id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR(50) NOT NULL UNIQUE,
	Fullname VARCHAR(50),
    `Password` VARCHAR(50) NOT NULL,
	ExpInYear TINYINT UNSIGNED,
    ProSkill VARCHAR(10),
    `Role` ENUM ('Admin', 'Employee')
);

INSERT INTO `User` (Email, Fullname, `Password`, ExpInYear, `Role`) VALUES 
('dtritton0@sphinn.com', 'Dionis Tritton', 'W4CQwKgEBXmu', 3, 'Admin'),
('ashakesbye1@mlb.com', 'Arv Shakesbye', '7pHdvvnNcrs', 1, 'Admin');
INSERT INTO `User` (Email, Fullname, `Password`, ProSkill, `Role`) VALUES 
('agrigoriev3@mit.edu', 'Alexine Grigoriev', 'NhcHDfwh1Fr', 'dev', 'Employee'),
('vloding4@jalbum.net', 'Virgie Loding', '0ij17u20mh', 'java', 'Employee'),
('adurtnall9@etsy.com', 'Alexis Durtnall', 'Jg5nRYo0ZaMO', 'sql', 'Employee'),
('fcandlin7@army.mil', 'Farlie Candlin', '6B6peju', 'python', 'Employee'),
('kkingdonl@toplist.cz', 'Kevyn Kingdon', 'VPNoqY', 'c++', 'Employee');
