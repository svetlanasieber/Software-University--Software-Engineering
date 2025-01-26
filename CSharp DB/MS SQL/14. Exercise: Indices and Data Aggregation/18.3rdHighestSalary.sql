-- 18. 3rd Highest Salary

SELECT [DepartmentID]
     , MAX([Salary]) AS [ThirdHighestSalary]
FROM
    (SELECT [DepartmentID]
            , [Salary]
            , DENSE_RANK() OVER (PARTITION BY [DepartmentID] ORDER BY [Salary] DESC ) AS [ThirdHighestSalary]
    FROM Employees
    ) AS [sal]
WHERE ThirdHighestSalary = 3
GROUP BY [DepartmentID]
