
/* Example Stored Procedures */
DELIMITER $$

CREATE PROCEDURE GetCustomers()
BEGIN
	SELECT
		customerName,
		city,
		state,
		postalCode,
		country
	FROM
		customers
	ORDER BY 
		customerName;
END$$
DELIMITER ;

DELIMITER // 
CREATE PROCEDURE GetOfficeByCountry(
	IN countryName VARCHAR(255)
)
BEGIN
	SELECT *
	FROM offices
	WHERE country = countryName;
END //
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE GetOrderCountByStatus (
	IN orderStatus VARCHAR(25),
	OUT total INT
)
BEGIN
	SELECT COUNT(orderNumber)
	INTO total
	FROM orders 
	WHERE status = orderStatus;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE SetCounter(
	INOUT counter INT,
	IN inc INT
)
BEGIN
	SET counter = counter + inc;
END$$
DELIMITER ;

/* Calling Example Procedures (Corresponding To Above Order) */
CALL GetCustomers();

CALL GetOfficeByCountry('USA');

CALL GetOrderCountByStatus('Shipped', @total);
SELECT @total;

SET @counter = 1;
CALL SetCounter(@counter, 1); -- 2
CALL SetCounter(@counter, 1); -- 3
CALL SetCounter(@counter, 5); -- 8
SELECT @counter; -- 8

/* Example Stored Function */
DELIMITER $$
CREATE FUNCTION CustomerLevel (
	credit DECIMAL(10,2)
)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
	DECLARE customerLevel VARCHAR(20);
	
	IF credit > 50000 THEN
		SET customerLevel = 'PLATINUM';
	ELSEIF (credit >= 50000 AND 
			credit <= 10000) THEN
		SET customerLevel = 'GOLD';
	ELSEIF credit < 10000 THEN
		SET customerLevel = 'SILVER';
	END IF;
	-- return the customer LEVEL
	RETURN (customerLevel);
END$$
DELIMITER ;

/* Calling Above Stored Function In An SQL Statement */
SELECT
	customerName,
	CustomerLevel(creditLimit)
FROM
	customers
ORDER BY
	customerName;

/* Dropping A Stored Function Example */
DROP FUNCTION OrderLeadTime;