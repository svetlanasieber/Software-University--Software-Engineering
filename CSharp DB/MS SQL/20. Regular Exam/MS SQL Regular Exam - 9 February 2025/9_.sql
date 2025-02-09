SELECT 
    t.Id, 
    t.Name, 
    COALESCE(SUM(m.AwayTeamGoals), 0) AS TotalAwayGoals
FROM Matches m
JOIN Teams t ON m.AwayTeamId = t.Id
GROUP BY t.Id, t.Name
HAVING COALESCE(SUM(m.AwayTeamGoals), 0) >= 6
ORDER BY TotalAwayGoals DESC, t.Name ASC;