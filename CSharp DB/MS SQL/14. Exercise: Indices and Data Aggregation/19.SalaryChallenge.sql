-- 19. Salary Challenge

SELECT TOP(10)
    FirstName,
    LastName,
    Employees.DepartmentID
FROM Employees
JOIN
(
SELECT
    DepartmentID
    , AVG([Salary]) AS [Average]
FROM Employees
GROUP BY DepartmentID
) as EA
ON Employees.DepartmentID = EA.[DepartmentID]
WHERE [Salary] > [Average]
