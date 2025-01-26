-- 03. Longest Magic Wand Per Deposit Groups

SELECT
    [DepositGroup]
    , MAX([MagicWandSize]) as [LongestMagicWand]
FROM WizzardDeposits
GROUP BY DepositGroup
