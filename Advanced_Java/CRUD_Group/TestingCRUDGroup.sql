-- create database
DROP DATABASE IF EXISTS TestingCRUDGroup;
CREATE DATABASE TestingCRUDGroup;
USE TestingCRUDGroup;

-- create table: Department
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName		NVARCHAR(30) NOT NULL UNIQUE KEY,
    MemberAmount 	INT UNSIGNED NOT NULL DEFAULT 0,
    Creator 		NVARCHAR(50) NOT NULL DEFAULT 'NAT',
    CreateDate 		DATETIME NOT NULL DEFAULT NOW()
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Group
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Marketing', 15, 'Artus Cranefield', '2021/07/10');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Sales', 50, 'Faydra Percival', '2021/04/23');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Legal', 36, 'Daveta Labrum', '2021/12/03');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Human Resources', 40, 'Eustace Doudney', '2021/07/15');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Resources', 34, 'Selie Sher', '2021/11/14');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Sales1', 20, 'Amalle Djurisic', '2021/07/18');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Research and Development', 27, 'Esme Kondratowicz', '2021/07/19');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Services', 28, 'Had Greatrakes', '2021/10/19');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Training', 29, 'Gavra Oxtaby', '2021/04/10');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Product Management', 43, 'Jessalin Renahan', '2021/07/03');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Marketing1', 43, 'Gabbey Gorwood', '2021/11/17');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Accounting1', 29, 'Arny Rosbrough', '2021/05/13');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Human', 27, 'Florinda Faccini', '2022/01/16');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Accounting', 34, 'Manuel Neylon', '2021/08/25');
insert into `Group` (GroupName, MemberAmount, Creator, CreateDate) values ('Resources2', 21, 'Rudolph Shipsey', '2021/10/25');