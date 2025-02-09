-- Create function: League Top Scorer
CREATE FUNCTION udf_LeagueTopScorer (@LeagueName NVARCHAR(50))
RETURNS TABLE
AS
RETURN (
    SELECT p.Name AS PlayerName, ps.Goals AS TotalGoals
    FROM PlayerStats ps
    JOIN Players p ON ps.PlayerId = p.Id
    JOIN PlayersTeams pt ON p.Id = pt.PlayerId
    JOIN Teams t ON pt.TeamId = t.Id
    JOIN Leagues l ON t.LeagueId = l.Id
    WHERE l.Name = @LeagueName AND ps.Goals = (
        SELECT MAX(ps2.Goals)
        FROM PlayerStats ps2
        JOIN Players p2 ON ps2.PlayerId = p2.Id
        JOIN PlayersTeams pt2 ON p2.Id = pt2.PlayerId
        JOIN Teams t2 ON pt2.TeamId = t2.Id
        JOIN Leagues l2 ON t2.LeagueId = l2.Id
        WHERE l2.Name = @LeagueName
    )
);