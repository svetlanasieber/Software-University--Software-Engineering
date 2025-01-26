-- 17. Employees Count Salaries

SELECT
    COUNT([Salary]) AS Count
FROM Employees
WHERE ManagerID IS NULL
