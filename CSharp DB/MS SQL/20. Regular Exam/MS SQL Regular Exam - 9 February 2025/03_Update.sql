-- Update Player Statistics for Forwards in La Liga
UPDATE PlayerStats
SET Goals = Goals + 1
WHERE PlayerId IN (
    SELECT pt.PlayerId
    FROM PlayersTeams pt
    JOIN Teams t ON pt.TeamId = t.Id
    JOIN Leagues l ON t.LeagueId = l.Id
    JOIN Players p ON pt.PlayerId = p.Id
    WHERE l.Name = 'La Liga' AND p.Position = 'Forward'
);