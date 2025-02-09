-- Query: Matches by Goals and Date
SELECT 
    FORMAT(MatchDate, 'yyyy-MM-dd') AS MatchDate,
    HomeTeamGoals,
    AwayTeamGoals,
    (HomeTeamGoals + AwayTeamGoals) AS TotalGoals
FROM Matches
WHERE (HomeTeamGoals + AwayTeamGoals) >= 5
ORDER BY TotalGoals DESC, MatchDate ASC;