-- 12. Rich Wizard, Poor Wizard

SELECT
    SUM(wizz1.DepositAmount - wizz2.DepositAmount) AS [SumDifference]
FROM WizzardDeposits AS [wizz1]
LEFT JOIN WizzardDeposits AS [wizz2] ON wizz1.Id = wizz2.Id - 1
