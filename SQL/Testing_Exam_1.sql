DROP DATABASE IF EXISTS Testing_Exam_1;
CREATE DATABASE Testing_Exam_1;
USE Testing_Exam_1;

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer(
	CustomerID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(50) NOT NULL,
    Phone CHAR(12) NOT NULL,
    Email VARCHAR(50),
    Address VARCHAR(200) NOT NULL,
    Note VARCHAR(500)
);

DROP TABLE IF EXISTS Car;
CREATE TABLE Car(
	CarID INT UNSIGNED PRIMARY KEY,
    Maker ENUM('HONDA','TOYOTA','NISSAN'),
    Model VARCHAR(30) NOT NULL,
    `Year` SMALLINT(4) NOT NULL,
    Color VARCHAR(20) NOT NULL,
    Note TEXT
);

DROP TABLE IF EXISTS Car_order;
CREATE TABLE Car_order(
	OrderID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT UNSIGNED NOT NULL,
    CarID INT UNSIGNED NOT NULL,
    Amount TINYINT UNSIGNED NOT NULL DEFAULT 1,
    SalePrice BIGINT UNSIGNED NOT NULL,
    OrderDate DATE NOT NULL,
    DeliveryDate DATE,
    DeliveryAddress VARCHAR(200),
    `Status` ENUM('0', '1', '2') DEFAULT '0' NOT NULL,
    Note TEXT,
FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID) ON DELETE CASCADE,
FOREIGN KEY (CarID) REFERENCES Car (CarID) ON DELETE NO ACTION
);

insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (1, 'Windy Mishow', '658 833 7315', null, '29 Ohio Alley', 'Reconstruction of urinary bladder');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (2, 'Taber Headley', '714 316 7010', 'theadley1@npr.org', '3 Hovde Alley', 'Removal of intraluminal foreign body from trachea and bronchus without incision');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (3, 'Quintin Blasing', '940 822 9974', 'qblasing2@epa.gov', '5 Claremont Trail', 'Suture of laceration of urethra');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (4, 'Duke Pead', '877 995 3410', 'dpead3@nhs.uk', '5055 Ilene Avenue', 'Revision of facet replacement device(s)');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (5, 'Geoffrey Farley', '816 720 8911', 'gfarley4@ftc.gov', '93277 Kings Way', 'Classical cesarean section');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (6, 'Ofelia Ezzle', '219 273 9008', 'oezzle5@smugmug.com', '305 Knutson Crossing', 'Pharyngeal diverticulectomy');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (7, 'Ronica Wyldish', '225 340 2513', 'rwyldish6@blogs.com', '0 Hansons Junction', 'Excision of lesion of tonsil and adenoid');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (8, 'Em Thunnercliffe', '316 436 1489', 'ethunnercliffe7@wired.com', '366 Bultman Terrace', 'Other local destruction or excision of renal lesion or tissue');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (9, 'Brnaba Juanico', '919 434 6808', 'bjuanico8@flavors.me', '94 Welch Parkway', 'Alcohol rehabilitation and detoxification');
insert into Customer (CustomerID, Name, Phone, Email, Address, Note) values (10, 'Elmer Top', '470 802 2458', 'etop9@chronoengine.com', '90561 Tennyson Plaza', 'Other and open bilateral repair of inguinal hernia, one direct and one indirect, with graft or prosthesis');

insert into Car (CarID, Model, Year, Color, Note) values (1, 'Forester', 2011, 'Aquamarine', 'Procedure on two vessels');
insert into Car (CarID, Model, Year, Color, Note) values (2, 'Taurus', 1996, 'Aquamarine', null);
insert into Car (CarID, Model, Year, Color, Note) values (3, 'Dakota', 2009, 'Fuscia', 'Other fixation of small intestine');
insert into Car (CarID, Model, Year, Color, Note) values (4, 'IS-F', 2012, 'Green', 'Lysis of pharyngeal adhesions');
insert into Car (CarID, Model, Year, Color, Note) values (5, 'Silverado 1500', 2004, 'Blue', 'Closed osteoplasty [osteotomy] of mandibular ramus');
insert into Car (CarID, Model, Year, Color, Note) values (6, 'Sienna', 1999, 'Pink', 'Closed [endoscopic] biopsy of larynx');
insert into Car (CarID, Model, Year, Color, Note) values (7, 'Spectra', 2003, 'Violet', null);
insert into Car (CarID, Model, Year, Color, Note) values (8, 'Firebird', 1994, 'Puce', 'Other excision or destruction of lesion of uterus');
insert into Car (CarID, Model, Year, Color, Note) values (9, 'Corvette', 1958, 'Teal', null);
insert into Car (CarID, Model, Year, Color, Note) values (10, '2500 Club Coupe', 1996, 'Violet', null);
insert into Car (CarID, Model, Year, Color, Note) values (11, 'Blazer', 1995, 'Pink', null);
insert into Car (CarID, Model, Year, Color, Note) values (12, 'H2', 2005, 'Blue', null);
insert into Car (CarID, Model, Year, Color, Note) values (13, 'Town & Country', 2011, 'Crimson', 'Insertion of totally implantable infusion pump');
insert into Car (CarID, Model, Year, Color, Note) values (14, 'Carens', 2008, 'Goldenrod', 'Contrast pancreatogram');
insert into Car (CarID, Model, Year, Color, Note) values (15, 'Montero', 2002, 'Puce', 'Gluteal artery perforator (GAP) flap, free');
insert into Car (CarID, Model, Year, Color, Note) values (16, 'Tredia', 1984, 'Indigo', 'Removal of T-tube, other bile duct tube, or liver tube');
insert into Car (CarID, Model, Year, Color, Note) values (17, '9-5', 2010, 'Fuscia', 'Excision of lesion of tendon sheath of hand');
insert into Car (CarID, Model, Year, Color, Note) values (18, 'E150', 1984, 'Indigo', 'Placement of intracerebral catheter(s) via burr hole(s)');
insert into Car (CarID, Model, Year, Color, Note) values (19, '6 Series', 1989, 'Indigo', 'Extracorporeal immunoadsorption');
insert into Car (CarID, Model, Year, Color, Note) values (20, 'Grand Prix', 2008, 'Teal', 'Other operations on spinal cord and spinal canal structures');
insert into Car (CarID, Model, Year, Color, Note) values (21, 'Diamante', 1996, 'Pink', 'Audiological evaluation');
insert into Car (CarID, Model, Year, Color, Note) values (22, 'Express', 2006, 'Aquamarine', 'Reimplantation of aberrant renal vessel');
insert into Car (CarID, Model, Year, Color, Note) values (23, 'Loyale', 1990, 'Aquamarine', null);
insert into Car (CarID, Model, Year, Color, Note) values (24, 'S-Type', 2000, 'Goldenrod', 'Biopsy of gum');
insert into Car (CarID, Model, Year, Color, Note) values (25, 'X6 M', 2010, 'Red', null);
insert into Car (CarID, Model, Year, Color, Note) values (26, 'Tempo', 1991, 'Green', 'Open biopsy of seminal vesicles');
insert into Car (CarID, Model, Year, Color, Note) values (27, 'Cabriolet', 1990, 'Mauv', null);
insert into Car (CarID, Model, Year, Color, Note) values (28, 'M6', 2006, 'Yellow', 'Bone thermography');
insert into Car (CarID, Model, Year, Color, Note) values (29, 'Sephia', 1995, 'Fuscia', 'Insertion of esophageal obturator airway');
insert into Car (CarID, Model, Year, Color, Note) values (30, '57', 2003, 'Blue', null);
insert into Car (CarID, Model, Year, Color, Note) values (31, 'Corolla', 2000, 'Turquoise', null);
insert into Car (CarID, Model, Year, Color, Note) values (32, 'Taurus X', 2009, 'Violet', null);
insert into Car (CarID, Model, Year, Color, Note) values (33, 'Expo', 1994, 'Khaki', 'Other diagnostic procedures on small intestine');
insert into Car (CarID, Model, Year, Color, Note) values (34, 'Expo', 1994, 'Green', 'Arteriography of other specified sites');
insert into Car (CarID, Model, Year, Color, Note) values (35, 'Sportvan G10', 1992, 'Turquoise', null);
insert into Car (CarID, Model, Year, Color, Note) values (36, 'TL', 2006, 'Orange', null);
insert into Car (CarID, Model, Year, Color, Note) values (37, 'LX', 2010, 'Indigo', 'Repair of bladder exstrophy');
insert into Car (CarID, Model, Year, Color, Note) values (38, 'Familia', 1991, 'Pink', 'Pressurized treatment of venous bypass graft [conduit] with pharmaceutical substance');
insert into Car (CarID, Model, Year, Color, Note) values (39, 'Wrangler', 1992, 'Puce', 'Arthrotomy for removal of prosthesis without replacement, wrist');
insert into Car (CarID, Model, Year, Color, Note) values (40, 'Ram', 2007, 'Mauv', null);
insert into Car (CarID, Model, Year, Color, Note) values (41, 'Sidekick', 1997, 'Violet', 'Iridencleisis and iridotasis');
insert into Car (CarID, Model, Year, Color, Note) values (42, '740', 1992, 'Khaki', 'Wedge osteotomy, other bones');
insert into Car (CarID, Model, Year, Color, Note) values (43, '3500', 1998, 'Yellow', 'Antesternal esophagogastrostomy');
insert into Car (CarID, Model, Year, Color, Note) values (44, 'Skyhawk', 1986, 'Puce', 'Injection of antibiotic');
insert into Car (CarID, Model, Year, Color, Note) values (45, 'Bronco', 1990, 'Violet', 'Repair of brain');
insert into Car (CarID, Model, Year, Color, Note) values (46, 'Endeavor', 2006, 'Green', 'Other operations on spermatic card, epididymis, and vas deferens');
insert into Car (CarID, Model, Year, Color, Note) values (47, 'W201', 1989, 'Mauv', null);
insert into Car (CarID, Model, Year, Color, Note) values (48, 'IS-F', 2010, 'Khaki', 'Other repair of ureter');
insert into Car (CarID, Model, Year, Color, Note) values (49, 'Navigator', 2004, 'Blue', 'Iridotomy with transfixion');
insert into Car (CarID, Model, Year, Color, Note) values (50, 'Murano', 2004, 'Aquamarine', 'Other local destruction or excision of renal lesion or tissue');

UPDATE Car SET Maker = 'HONDA' WHERE CarID = 1;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 2;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 3;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 4;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 5;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 6;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 7;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 8;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 9;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 10;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 11;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 12;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 13;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 14;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 15;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 16;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 17;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 18;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 19;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 20;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 21;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 22;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 23;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 24;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 25;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 26;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 27;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 28;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 29;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 30;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 31;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 32;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 33;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 34;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 35;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 36;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 37;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 38;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 39;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 40;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 41;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 42;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 43;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 44;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 45;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 46;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 47;
UPDATE Car SET Maker = 'NISSAN' WHERE CarID = 48;
UPDATE Car SET Maker = 'HONDA' WHERE CarID = 49;
UPDATE Car SET Maker = 'TOYOTA' WHERE CarID = 50;

insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (1, 3, 16, 3, 1510607548, '2021-08-01', '2021-11-03', '262 Clove Parkway', '0', 'Osteomalacia NOS');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (2, 6, 45, 3, 2257939745, '2021-06-12', '2021-10-22', '99384 Talmadge Center', '1', 'Fx mlt cervical vert-opn');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (3, 3, 3, 2, 903379413, '2021-07-28', '2021-11-16', '10 Oak Valley Junction', '1', 'TB thorax node-histo dx');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (4, 9, 9, 1, 1622579069, '2021-07-02', '2021-11-08', '325 Mallard Street', '1', 'Maj puer inf NOS-del p/p');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (5, 8, 26, 2, 2042843257, '2021-07-21', '2021-11-22', '42020 Prairieview Pass', '2', 'Ca in situ fem gen NOS');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (6, 7, 45, 1, 3831811093, '2021-06-21', '2021-11-24', '4977 Milwaukee Place', '2', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (7, 6, 31, 2, 1069852957, '2021-08-17', '2021-10-23', '83904 Carioca Pass', '2', 'Preterm NEC 1000-1249g');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (8, 1, 3, 2, 3190501443, '2021-05-29', '2021-09-26', '0 Luster Road', '0', 'Perin hematoma-postpart');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (9, 5, 39, 1, 735988200, '2021-07-08', '2021-11-15', '1 Leroy Alley', '1', 'Biceps tendon rupture');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (10, 4, 46, 1, 1872095492, '2021-06-25', '2021-11-13', '9 6th Avenue', '1', 'MRSA elsewhere/NOS');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (11, 2, 28, 1, 3487142668, '2021-08-21', '2021-11-02', '61575 Loeprich Circle', '1', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (12, 4, 38, 3, 4785870991, '2021-07-24', '2021-10-12', '04569 Golf Course Way', '2', 'Mitral stenosis');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (13, 4, 39, 1, 2804837830, '2021-07-18', '2021-11-10', '06 Dorton Court', '1', 'AMI anterior wall, init');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (14, 10, 19, 1, 1143130366, '2021-06-01', '2021-10-06', '8544 Atwood Drive', '0', 'Cl skull vlt fx-brf coma');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (15, 1, 11, 2, 2224154538, '2021-06-26', '2021-10-28', '61220 Delaware Street', '1', 'Benign neo nerv sys NOS');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (16, 5, 40, 1, 3509970688, '2021-07-28', '2021-10-17', '80617 Transport Place', '2', 'Screen for malnutrition');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (17, 10, 18, 3, 777491404, '2021-07-08', '2021-10-03', '3 Troy Parkway', '1', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (18, 5, 35, 1, 1356868086, '2021-05-30', '2021-11-20', '3 Kim Way', '2', 'Ear anom NOS/impair hear');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (19, 1, 6, 3, 2387993725, '2021-07-16', '2021-11-07', '8850 Sheridan Center', '2', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (20, 1, 47, 1, 4803049582, '2021-07-01', '2021-10-28', '67 Morrow Alley', '0', 'Dislocation ear ossicle');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (21, 1, 39, 2, 2417550751, '2021-06-05', '2021-11-13', '3003 Farwell Center', '2', 'Leukoplakia oral mucosa');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (22, 4, 50, 3, 1614259717, '2021-06-26', '2021-10-23', '71 Pepper Wood Terrace', '2', 'TB thorax node-histo dx');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (23, 8, 45, 2, 4966275791, '2021-07-30', '2021-10-27', '17836 Oakridge Alley', '2', 'Breast infect NOS-deliv');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (24, 4, 31, 3, 3817391118, '2021-05-26', '2021-11-10', '85669 Mallard Drive', '0', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (25, 7, 34, 1, 2064108580, '2021-08-08', '2021-10-27', '357 Autumn Leaf Plaza', '2', 'Isol tracheal tb-no exam');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (26, 3, 17, 3, 3255860289, '2021-06-18', '2021-11-18', '304 Becker Crossing', '2', 'C1-c4 fx-op/cord inj NOS');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (27, 7, 3, 3, 2199955256, '2021-06-08', '2021-09-28', '7 Ohio Way', '1', 'Hyperestrogenism');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (28, 3, 21, 1, 2286515243, '2021-07-03', '2021-11-16', '8 Clyde Gallagher Alley', '1', 'Lumbosacral plex lesion');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (29, 3, 32, 1, 698204762, '2021-07-06', '2021-11-22', '469 Westport Road', '2', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (30, 8, 23, 3, 4924398998, '2021-06-26', '2021-10-23', '643 Coolidge Court', '1', 'Urin-genital fistul, fem');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (31, 5, 1, 3, 1298155782, '2021-08-01', '2021-11-17', '0 Manley Way', '1', 'Adv eff card rhyth regul');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (32, 4, 4, 3, 2378077997, '2021-06-09', '2021-11-15', '30974 Dovetail Place', '1', 'Poison-sedat/hypnotic');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (33, 3, 38, 1, 4761609495, '2021-07-10', '2021-11-24', '57 Johnson Court', '1', 'Family dsrpt-estrangmemt');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (34, 5, 11, 1, 4272720506, '2021-06-27', '2021-10-24', '9 Moose Avenue', '1', 'Gen nonconv ep w intr ep');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (35, 3, 45, 1, 3396616031, '2021-08-17', '2021-10-07', '00 Manufacturers Trail', '1', 'Renal colic');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (36, 3, 11, 3, 4393805273, '2018-08-14', '2021-11-24', '4 Bartillon Plaza', '2', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (37, 7, 28, 3, 3376995851, '2021-06-12', '2021-11-23', '4502 Mallory Parkway', '0', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (38, 8, 12, 3, 2107001047, '2021-06-03', '2021-10-30', '97631 Evergreen Point', '2', 'TB skin/subcut-exam unkn');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (39, 3, 3, 1, 3462156551, '2021-05-27', '2021-11-18', '20045 Cherokee Court', '1', 'Headache');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (40, 2, 35, 2, 4704035757, '2018-07-11', '2021-10-27', '65736 Westridge Avenue', '2', 'Puerp compl NOS-postpart');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (41, 9, 2, 1, 1255636388, '2021-07-29', '2021-11-17', '78819 Bobwhite Park', '1', 'Adv eff antineoplastic');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (42, 1, 44, 2, 4962055440, '2021-07-26', '2021-11-03', '90 Mockingbird Pass', '1', 'Abn basal metabol study');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (43, 6, 31, 3, 3247422349, '2017-07-05', '2021-09-30', '00 Mallard Road', '1', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (44, 4, 15, 3, 1045932839, '2021-06-17', '2021-10-15', '8943 Caliangt Junction', '1', 'Radiotherapy encounter');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (45, 4, 21, 1, 1203410041, '2019-06-01', '2021-10-14', '18 Bunting Avenue', '0', 'Cl skl w oth fx-mod coma');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (46, 5, 30, 2, 603695384, '2019-06-15', '2021-10-08', '9 Rutledge Drive', '2', 'TB lung w cavit-micro dx');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (47, 2, 48, 1, 2516112612, '2018-07-12', '2021-09-29', '5702 Carpenter Avenue', '1', 'Epimembranous nephritis');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (48, 3, 44, 2, 4751901283, '2021-08-17', '2021-11-23', '09012 Lakeland Parkway', '1', 'Gc orchitis (acute)');
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (49, 9, 29, 2, 4426576630, '2021-07-28', '2021-10-25', '440 Clarendon Park', '0', null);
insert into Car_order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) values (50, 1, 48, 2, 1064638394, '2018-08-03', '2021-11-23', '24 Atwood Parkway', '1', null);

UPDATE Car_Order SET DeliveryDate = NULL WHERE `Status` = '2';

/* Question 2: Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
mua và sắp sếp tăng dần theo số lượng oto đã mua.*/

SELECT c.`Name`, co.Amount
FROM Customer c
JOIN Car_Order co
ON c.CustomerID = co.CustomerID
ORDER BY co.Amount;

/* Question 3: Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
oto nhất trong năm nay*/
SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS f_get_max_maker;
DELIMITER $$
CREATE FUNCTION f_get_max_maker () RETURNS CHAR(6)
BEGIN
	DECLARE max_maker CHAR(6);
	SELECT DISTINCT c.Maker INTO max_maker
	FROM Car c
	JOIN Car_Order co
	ON c.CarID = co.CarID
	WHERE c.CarID IN	
    
    (SELECT co.CarID
	FROM Car_Order co
	GROUP BY co.CarID
	HAVING COUNT(co.CarID) = 	(SELECT MAX(Car_count)
								FROM	(SELECT COUNT(co.CarID)  AS Car_count
										FROM Car_Order co
										JOIN Car c
										ON co.CarID = c.CarID
										WHERE YEAR(DeliveryDate) = YEAR(NOW())
										GROUP BY c.CarID) AS query1))
	LIMIT 1;
	RETURN max_maker;
END $$
DELIMITER ;

SELECT f_get_max_maker ();

/* Question 4: Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
những năm trước. In ra số lượng bản ghi đã bị xóa.*/
DROP PROCEDURE IF EXISTS p_canceled_order_del;
DELIMITER $$
CREATE PROCEDURE p_canceled_order_del ()
BEGIN
	DELETE FROM Car_Order
	WHERE YEAR(NOW()) - YEAR(OrderDate) > 0
	AND `Status` = '2';
	SELECT ROW_COUNT();
END $$
DELIMITER ;

SELECT * FROM Car_Order
WHERE YEAR(NOW()) - YEAR(OrderDate) > 0
AND `Status` = '2';

CALL p_canceled_order_del ();

/* Question 5: Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
và tên hãng sản xuất.*/
DROP PROCEDURE IF EXISTS p_get_order_info;
DELIMITER $$
CREATE PROCEDURE p_get_order_info (IN in_CustomerID INT UNSIGNED)
BEGIN
	SELECT c.`Name`, co.OrderID, co.Amount, ca.Maker
    FROM Customer c
    JOIN Car_Order co
    ON co.CustomerID = c.CustomerID
    JOIN Car ca
    ON co.CarID = ca.CarID
    WHERE co.CustomerID = in_CustomerID;
END $$
DELIMITER ;

CALL p_get_order_info (10);