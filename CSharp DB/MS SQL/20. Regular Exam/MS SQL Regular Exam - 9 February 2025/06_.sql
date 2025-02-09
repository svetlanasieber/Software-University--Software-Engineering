

-- Query: Players with 'Aaron' in their name and corresponding city
SELECT 
    p.Name, 
    t.City 
FROM Players p
JOIN PlayersTeams pt ON p.Id = pt.PlayerId
JOIN Teams t ON pt.TeamId = t.Id
WHERE p.Name LIKE '%Aaron%'
ORDER BY p.Name ASC;