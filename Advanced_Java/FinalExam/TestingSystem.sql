-- Drop the database if it already exists
DROP DATABASE IF EXISTS Java_Advanced_Final_Exam;
-- Create database
CREATE DATABASE IF NOT EXISTS Java_Advanced_Final_Exam;
USE Java_Advanced_Final_Exam;

-- Create table Department
DROP TABLE IF EXISTS 	`Department`;
CREATE TABLE IF NOT EXISTS `Department` (
	DepartmentId 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	DepartmentName 			NVARCHAR(50) NOT NULL UNIQUE KEY,
    DepartmentType			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL,
    CreateDate				DATETIME DEFAULT NOW()
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Username				VARCHAR(18) NOT NULL UNIQUE KEY,
	`Password` 				VARCHAR(12) NOT NULL,
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,
    `Role` 					ENUM('Admin','Employee','Manager') NOT NULL DEFAULT 'Employee',
    DepartmentID 			INT UNSIGNED NOT NULL,
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID)
);

-- =============================================
-- INSERT DATA 
-- =============================================
-- Add data Department
INSERT INTO Department(	DepartmentName,		DepartmentType,		CreateDate) 
VALUES
						(N'Marketing'	,		'Dev', 			'2010-03-05'),
						(N'Sale'		,		'Test', 		'2013-07-05'),
						(N'Security'	,		'ScrumMaster', 	'2018-11-20'),
						(N'HR'			,		'PM', 			'2015-06-08'),
						(N'Kỹ thuật'	,		'Dev', 			'2012-09-10'),
						(N'Tài chính'	,		'ScrumMaster', 	NOW()		),
						(N'Phó giám đốc',		'PM', 			NOW()		),
						(N'Giám đốc'	,		'Test', 		'2019-10-14'),
						(N'Thư kí'		,		'PM', 			'2020-12-22'),
						(N'Bán hàng'	,		'Dev', 			'2021-08-26');
                    
-- Add data Account
-- Password: 123456
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (1, 'folivetta0', 'CWbQmJS', 'Francisco', 'Olivetta', 'Admin', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (2, 'vwhitwell1', 'DGiDPNm', 'Vin', 'Whitwell', 'Manager', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (3, 'abercevelo2', 'E6uPfafl', 'Abner', 'Bercevelo', 'Manager', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (4, 'wmonketon3', 'kBuPrag8t', 'Waring', 'Monketon', 'Employee', 10);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (5, 'pfylan4', 'qyhuYUSWhqUk', 'Prentiss', 'Fylan', 'Admin', 9);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (6, 'dporkiss5', 'mTMFKOImlm6o', 'Dru', 'Porkiss', 'Admin', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (7, 'lnicolson6', 'GRxLEETHx5KP', 'Louie', 'Nicolson', 'Manager', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (8, 'nwybern7', 'qXcRHtHJ', 'Nigel', 'Wybern', 'Admin', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (9, 'fhortop8', '9jq9BZYGGoan', 'Fields', 'Hortop', 'Admin', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (10, 'sbampton9', 'iM5dUZFxon', 'Sim', 'Bampton', 'Manager', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (11, 'fbennella', 'sDy0wRAsr', 'Frank', 'Bennell', 'Employee', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (12, 'blickorishb', 'lBmLif', 'Brodie', 'Lickorish', 'Employee', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (13, 'qcasperric', 'wMOngC9pkV', 'Quill', 'Casperri', 'Manager', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (14, 'bangelld', 'CIpP9t0sN8kS', 'Brose', 'Angell', 'Admin', 5);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (15, 'nkeijsere', 'NbtI2VrXcg', 'Nikos', 'Keijser', 'Manager', 5);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (16, 'bbalthasarf', 'qDaPVZ0', 'Brady', 'Balthasar', 'Manager', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (17, 'rpoeg', 'MhQRXPZVNq', 'Rhys', 'Poe', 'Employee', 5);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (18, 'fcasserlyh', 'wpxRE7iWxdEN', 'Fergus', 'Casserly', 'Admin', 9);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (19, 'hshatfordi', 'Bb5FKSVdrtzh', 'Hamilton', 'Shatford', 'Admin', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (20, 'fharrildj', 'ONZCZIl', 'Fonsie', 'Harrild', 'Employee', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (21, 'rmarrisonk', '64TH3vPF', 'Randie', 'Marrison', 'Manager', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (22, 'mmattusovl', 'PHIM6MALMIFi', 'Marco', 'Mattusov', 'Admin', 5);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (23, 'mliddingtonm', '9rPU9z', 'Moore', 'Liddington', 'Employee', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (24, 'hfinicjn', 'XdKpJB', 'Herold', 'Finicj', 'Employee', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (25, 'omowburyo', 'UfsrSxN3uu', 'Ogdon', 'Mowbury', 'Employee', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (26, 'opetitp', 'nN33gwu6ZwI', 'Osgood', 'Petit', 'Admin', 10);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (27, 'cbrewisq', 'FIVNalsEAl84', 'Clarance', 'Brewis', 'Employee', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (28, 'gbickertonr', 'jdUqLhYz', 'Gerri', 'Bickerton', 'Manager', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (29, 'hambages', 'ZnKjvGtbwjK6', 'Haskel', 'Ambage', 'Manager', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (30, 'burlingt', 'AUjZd7V', 'Barry', 'Urling', 'Manager', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (31, 'bkrzyzaniaku', '6oXS5ZH', 'Brockie', 'Krzyzaniak', 'Employee', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (32, 'bdunnev', 'KRzoU3f', 'Bailey', 'Dunne', 'Admin', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (33, 'oloblew', 'YG9cn0hY9T', 'Obidiah', 'Loble', 'Manager', 5);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (34, 'irungex', '25ql0dg', 'Ikey', 'Runge', 'Employee', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (35, 'abroeky', '05MDcIckvj', 'Adriano', 'Broek', 'Employee', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (36, 'obrandlez', 'iKkgceyhp', 'Oswell', 'Brandle', 'Manager', 9);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (37, 'fpettiward10', '11X6TKumKqa', 'Fletcher', 'Pettiward', 'Manager', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (38, 'lmoffatt11', 'sLu8utH6Jv', 'Leon', 'Moffatt', 'Manager', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (39, 'iskrzynski12', 'GzUpH1myY', 'Ingemar', 'Skrzynski', 'Employee', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (40, 'vbehagg13', 'APycEBA', 'Vladimir', 'Behagg', 'Admin', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (41, 'icrasford14', 'RUxOFZ90zrr', 'Ilaire', 'Crasford', 'Admin', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (42, 'aselwin15', 'ilAiungz', 'Antons', 'Selwin', 'Employee', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (43, 'lmynott16', 'ImbQnW', 'Louie', 'Mynott', 'Employee', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (44, 'mmacpaik17', 'E9W5Ypk', 'Mario', 'MacPaik', 'Employee', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (45, 'ehallihane18', 'JmW0y7', 'Elia', 'Hallihane', 'Admin', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (46, 'rpeddar19', 'lxoOHpXxL', 'Robby', 'Peddar', 'Manager', 10);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (47, 'joldroyde1a', 'ZWppup', 'Jason', 'Oldroyde', 'Manager', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (48, 'rwitts1b', '14tCis3f', 'Rob', 'Witts', 'Employee', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (49, 'btromans1c', 'xIkZEB6ciVD', 'Byram', 'Tromans', 'Admin', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (50, 'dlongridge1d', 'QFgTEGJoJ', 'Del', 'Longridge', 'Employee', 10);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (51, 'sgumery1e', 'gPgxabaw', 'Scott', 'Gumery', 'Manager', 5);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (52, 'aodea1f', 'FxyXeE0W1wJ', 'Arie', 'O''Dea', 'Manager', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (53, 'ggullan1g', 'OQgpAD', 'Gareth', 'Gullan', 'Manager', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (54, 'egauch1h', 'kYhSIE3', 'Ely', 'Gauch', 'Admin', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (55, 'pposen1i', 'HHUffRMMi', 'Peyter', 'Posen', 'Manager', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (56, 'cleggatt1j', '4AhyYZc', 'Chauncey', 'Leggatt', 'Employee', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (57, 'gaikett1k', 'se7olzO0h', 'Gardy', 'Aikett', 'Employee', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (58, 'msadat1l', 'jpTYpPXJS95G', 'Mattias', 'Sadat', 'Manager', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (59, 'jleas1m', 'zgObX0F', 'Justino', 'Leas', 'Manager', 9);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (60, 'lbraunds1n', 'gGSqJDpVD', 'Liam', 'Braunds', 'Admin', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (61, 'bkisby1o', 'mnbxrvLeAmOb', 'Basilius', 'Kisby', 'Manager', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (62, 'aswaine1p', 'KxKvrRT13HLo', 'Antonino', 'Swaine', 'Admin', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (63, 'jduffield1q', 'WnAI3b8', 'Jase', 'Duffield', 'Manager', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (64, 'geisikowitch1r', 'pMW3GEvP', 'Geordie', 'Eisikowitch', 'Admin', 9);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (65, 'amaevela1s', 'kMTs0OU6', 'Antone', 'Maevela', 'Employee', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (66, 'oclinton1t', 'ePVD7ajq89so', 'Orton', 'Clinton', 'Admin', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (67, 'ealfonzo1u', 'zZBQBbVHOj', 'Etienne', 'Alfonzo', 'Employee', 9);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (68, 'ahartford1v', 'I4gWWqAX', 'Alfonse', 'Hartford', 'Manager', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (69, 'vstinchcombe1w', 'dWjQdAf54', 'Vic', 'Stinchcombe', 'Manager', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (70, 'tembury1x', 'Vi7HUNq4', 'Tyrone', 'Embury', 'Employee', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (71, 'hcoughan1y', 'kzE5khi', 'Howey', 'Coughan', 'Manager', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (72, 'tlandall1z', 'XmWFtmK', 'Thornton', 'Landall', 'Employee', 10);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (73, 'rkingh20', 'KB2DIRkx', 'Reynold', 'Kingh', 'Manager', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (74, 'spiers21', 'uQGe4EcnA', 'Sinclare', 'Piers', 'Manager', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (75, 'icaddock22', 'lpj6YlQG', 'Isaak', 'Caddock', 'Admin', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (76, 'awhittaker23', 'oUBMS3nsv8T', 'Alexandro', 'Whittaker', 'Employee', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (77, 'hgavahan24', 'FYYXPLjaaSy', 'Hurley', 'Gavahan', 'Employee', 5);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (78, 'hsweatman25', 'E5xzVSrfI7ji', 'Hans', 'Sweatman', 'Admin', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (79, 'ahulles26', 'bKIECILLYIO', 'Aymer', 'Hulles', 'Employee', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (80, 'reltringham27', 'FGkhhGg5fr', 'Richardo', 'Eltringham', 'Admin', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (81, 'ctomczykiewicz28', 'hIm1cQkXYXO', 'Cchaddie', 'Tomczykiewicz', 'Manager', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (82, 'hridgeway29', 'ci91KTjOKl9n', 'Harlin', 'Ridgeway', 'Employee', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (83, 'evoss2a', 'PU76dR', 'Elliott', 'Voss', 'Employee', 9);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (84, 'csettle2b', 'qcjEjl', 'Chrisse', 'Settle', 'Manager', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (85, 'rmaplethorpe2c', 'HNxykY5h', 'Rustie', 'Maplethorpe', 'Employee', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (86, 'rmcian2d', '44BUGs', 'Rolf', 'McIan', 'Manager', 1);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (87, 'agowman2e', '0RFGUIXjY', 'Avrom', 'Gowman', 'Employee', 7);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (88, 'mleynton2f', 'JIBbPJxJubs', 'Mathew', 'Leynton', 'Admin', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (89, 'fgrowcock2g', 'sYgf8KNdtf', 'Felix', 'Growcock', 'Manager', 3);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (90, 'fmcgettrick2h', 'qqQNA2a', 'Federico', 'McGettrick', 'Employee', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (91, 'cjeynes2i', 'MS2uj6eDD', 'Clyde', 'Jeynes', 'Manager', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (92, 'stilling2j', 'SaCkiy', 'Sol', 'Tilling', 'Admin', 10);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (93, 'wsleney2k', 'FQezMd5', 'Wyatan', 'Sleney', 'Employee', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (94, 'bcordeix2l', '5LjEsujNU6', 'Barnard', 'Cordeix', 'Manager', 2);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (95, 'bdismore2m', 'JSbfr8HXp', 'Beck', 'Dismore', 'Employee', 6);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (96, 'tstruthers2n', 'ceA7rYXNX', 'Truman', 'Struthers', 'Manager', 4);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (97, 'bogilvie2o', 'VRwnkGD8i', 'Benny', 'Ogilvie', 'Employee', 10);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (98, 'emcginley2p', 'iobaEI', 'Earlie', 'McGinley', 'Admin', 8);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (99, 'lbeeson2q', 'EwXnaOJ', 'Laird', 'Beeson', 'Employee', 9);
insert into `Account` (AccountID, Username, `Password`, FirstName, LastName, `Role`, DepartmentID) values (100, 'tjiras2r', 'IDw40gY', 'Trumaine', 'Jiras', 'Manager', 1);