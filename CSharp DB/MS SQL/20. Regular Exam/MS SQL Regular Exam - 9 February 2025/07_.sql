-- Query: Players in Teams Situated in London
SELECT 
    p.Id, 
    p.Name, 
    p.Position
FROM Players p
JOIN PlayersTeams pt ON p.Id = pt.PlayerId
JOIN Teams t ON pt.TeamId = t.Id
WHERE t.City = 'London'
ORDER BY p.Name ASC;