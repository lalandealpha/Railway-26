USE adventureworks;

-- Exercise 1
-- Question 1: Lấy tên của các sản phẩm mà ProductSubcategory là Saddles.
SELECT p.`Name`
FROM product p
JOIN productsubcategory ps
ON p.ProductSubcategoryID = ps.ProductSubcategoryID
WHERE ps.`Name` = 'Saddles';

/* Question 2: Thay đổi câu query ở question 1 để được kết quả như sau:
Name
----------------------------
Water Bottle - 30 oz.
Mountain Bottle Cage
Road Bottle Cage
LL Bottom Bracket
ML Bottom Bracket
HL Bottom Bracket
(6 row(s) affected)*/

SELECT p.`Name`
FROM product p
JOIN productsubcategory ps
ON p.ProductSubcategoryID = ps.ProductSubcategoryID
WHERE ps.`Name` LIKE 'Bo%';

-- Question 3: viết lệnh lấy ra sản phẩm có subcategory là Touring bikes và rẻ nhất.
SELECT p.`Name`
FROM product p
JOIN productsubcategory ps
ON p.ProductSubcategoryID = ps.ProductSubcategoryID
WHERE ps.`Name` = 'Touring Bikes'
AND p.ListPrice = 	(SELECT MIN(LP)
					FROM 	(SELECT p.ListPrice AS LP
							FROM product p
							JOIN productsubcategory ps
							ON p.ProductSubcategoryID = ps.ProductSubcategoryID
							WHERE ps.`Name` = 'Touring Bikes') AS query1);

-- Exercise 2
-- Question 1: Lấy danh sách country và province được lưu trong database.
SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
JOIN stateprovince s
ON c.CountryRegionCode = s.CountryRegionCode
ORDER BY Country;

-- Question 2: Lấy danh sách province của 2 nước Canada và Germany.
SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
JOIN stateprovince s
ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` IN ('Canada', 'Germany');
-- Cách 2: Dùng UNION SELECT
SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
JOIN stateprovince s
ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` = 'Canada'
UNION
SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
JOIN stateprovince s
ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` = 'Germany';

-- Question 3: Lấy ra tất cả các đơn hàng offline, ngày tạo đơn, người bán, tiền thưởng.
-- Không tìm thấy field BusinessEntityID
SELECT 	soh.SalesOrderID, soh.OrderDate, 
		sp.SalesPersonID, sp.Bonus, sp.SalesYTD
FROM 	salesperson sp
JOIN	salesorderheader soh
ON		sp.SalesPersonID = soh.SalesPersonID
WHERE	soh.OnlineOrderFlag = 0;

-- Question 4: Lấy ra tất cả các đơn hàng offline, ngày tạo đơn, tên công việc, tiền thưởng.
-- Không tìm thấy field JobTitle
SELECT 	soh.SalesOrderID, soh.OrderDate, 
		sp.SalesPersonID, sp.Bonus, sp.SalesYTD
FROM 	salesperson sp
JOIN	salesorderheader soh
ON		sp.SalesPersonID = soh.SalesPersonID
WHERE	soh.OnlineOrderFlag = 0;








