USE adventureworks;

-- Question 1: Lấy tên của các sản phẩm mà ProductSubcategory là Saddles.
SELECT p.Name
FROM product p
JOIN productsubcategory ps
ON p.ProductSubcategoryID = ps.ProductSubcategoryID
WHERE ps.Name = 'Saddles';