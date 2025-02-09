-- Query: First 10 matches in early September
SELECT TOP 10 
    t1.Name AS HomeTeamName,
    t2.Name AS AwayTeamName,
    l.Name AS LeagueName,
    FORMAT(m.MatchDate, 'yyyy-MM-dd') AS MatchDate
FROM Matches m
JOIN Teams t1 ON m.HomeTeamId = t1.Id
JOIN Teams t2 ON m.AwayTeamId = t2.Id
JOIN Leagues l ON m.LeagueId = l.Id
WHERE m.MatchDate BETWEEN '2024-09-01' AND '2024-09-15'
AND l.Id % 2 = 0
ORDER BY m.MatchDate ASC, t1.Name ASC;