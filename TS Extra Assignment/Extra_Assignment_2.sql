DROP DATABASE IF EXISTS Fresher_Training_MNG;
CREATE DATABASE Fresher_Training_MNG;
USE Fresher_Training_MNG;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee (
	TraineeID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name VARCHAR(50) NOT NULL,
	Birth_Date DATE NOT NULL,
    Gender ENUM('Male', 'Female', 'Unknown') DEFAULT 'Unknown',
    ET_IQ TINYINT(2) UNSIGNED NOT NULL CHECK (ET_IQ > 0 AND ET_IQ <20),
    ET_Gmath TINYINT(2) UNSIGNED NOT NULL CHECK (ET_Gmath > 0 AND ET_Gmath <20),
    ET_English TINYINT(2) UNSIGNED NOT NULL CHECK (ET_English > 0 AND ET_English <50),
    Training_Class INT UNSIGNED NOT NULL,
    Evaluation_Notes LONGTEXT
);

ALTER TABLE Trainee
ADD COLUMN VTI_Account VARCHAR(20) NOT NULL UNIQUE;

-- Exercise 2: Chọn kiểu dữ liệu phù hợp để tối ưu không gian lưu trữ
DROP TABLE IF EXISTS TSE_exer2;
CREATE TABLE TSE_exer2 (
	ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(30),
	`Code` CHAR(5),
	ModifiedDate DATETIME
);

-- Exercise 3: Chọn kiểu dữ liệu để tối ưu không gian lưu trữ
DROP TABLE IF EXISTS TSE_exer3;
CREATE TABLE TSE_exer3 (
	ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(30),
    BirthDate DATE,
    Gender ENUM ('0', '1', 'NULL'),
    IsDeletedFlag BIT
);