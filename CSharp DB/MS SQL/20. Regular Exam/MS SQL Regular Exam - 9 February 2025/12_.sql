-- Stored Procedure: Search for Teams by City
CREATE PROCEDURE usp_SearchTeamsByCity @CityName NVARCHAR(50)
AS
BEGIN
    SELECT t.Name AS TeamName, l.Name AS LeagueName, t.City
    FROM Teams t
    JOIN Leagues l ON t.LeagueId = l.Id
    WHERE t.City = @CityName
    ORDER BY t.Name ASC;
END;