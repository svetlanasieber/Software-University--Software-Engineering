-- 15. Employees Average Salaries

SELECT * INTO [TempTable]
FROM Employees
WHERE [Salary] > 30000

DELETE
FROM [TempTable]
WHERE [ManagerID] = 42

UPDATE TempTable
SET [Salary] += 5000
WHERE [DepartmentID] = 1

SELECT
    [DepartmentID]
    , AVG([Salary]) AS [AverageSalary]
FROM TempTable
GROUP BY [DepartmentID]
