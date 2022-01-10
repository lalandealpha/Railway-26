DROP DATABASE IF EXISTS Java_Practice_Test;
CREATE DATABASE Java_Practice_Test;
USE Java_Practice_Test;

DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin` (
	Id SMALLINT UNSIGNED PRIMARY KEY,
	Email VARCHAR(50) NOT NULL,
	Fullname VARCHAR(50),
    `Password` VARCHAR(50) NOT NULL,
	ExpInYear TINYINT UNSIGNED
);

INSERT INTO `Admin` (Id, Email, Fullname, `Password`, ExpInYear) VALUES 
(1, 'dtritton0@sphinn.com', 'Dionis Tritton', 'W4CQwKgEBXmu', 3),
(2, 'ashakesbye1@mlb.com', 'Arv Shakesbye', '7pHdvvnNcrs', 1);

DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
	Id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Email VARCHAR(50),
	Fullname VARCHAR(50),
    `Password` VARCHAR(50) NOT NULL,
    ProSkill VARCHAR(10)
);
ALTER TABLE `Employee` AUTO_INCREMENT = 10;
INSERT INTO `Employee` (Email, Fullname, `Password`, ProSkill) VALUES 
('agrigoriev3@mit.edu', 'Alexine Grigoriev', 'NhcHDfwh1Fr', 'dev'),
('vloding4@jalbum.net', 'Virgie Loding', '0ij17u20mh', 'java'),
('adurtnall9@etsy.com', 'Alexis Durtnall', 'Jg5nRYo0ZaMO', 'sql'),
('fcandlin7@army.mil', 'Farlie Candlin', '6B6peju', 'python'),
('kkingdonl@toplist.cz', 'Kevyn Kingdon', 'VPNoqY', 'c++');



