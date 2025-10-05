#524ms




SELECT name AS Customers
FROM Customers
LEFT JOIN Orders ON Customers.id = Orders.customerId
WHERE Orders.customerId IS NULL;




#600ms




SELECT Customers.name AS Customers
FROM Customers
LEFT JOIN Orders 
ON Customers.id = Orders.customerId
WHERE Orders.customerId is NULL
