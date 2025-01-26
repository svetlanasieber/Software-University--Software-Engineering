-- Part II - Queries for SoftUni Database

USE SoftUni
GO

-- 13. Departments Total Salaries

SELECT
    [DepartmentID]
    , SUM(Salary) AS [TotalSalary]
FROM Employees
GROUP BY [DepartmentID]
ORDER BY [DepartmentID]
