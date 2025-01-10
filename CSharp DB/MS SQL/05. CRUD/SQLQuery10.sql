CREATE VIEW v_EmplyeesProjection AS
SELECT
	CONCAT_WS('', FirstName, LastName) AS [Full Name]
	, Salary
FROM Employees