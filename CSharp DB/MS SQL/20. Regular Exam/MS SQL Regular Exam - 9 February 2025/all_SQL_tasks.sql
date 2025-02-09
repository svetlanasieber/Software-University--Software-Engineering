-- Create the database
CREATE DATABASE EuroLeagues;
GO

-- Use the database
USE EuroLeagues;
GO

-- Create Leagues table
CREATE TABLE Leagues (
    Id INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(50) NOT NULL
);

-- Create Teams table
CREATE TABLE Teams (
    Id INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(50) NOT NULL UNIQUE,
    City NVARCHAR(50) NOT NULL,
    LeagueId INT NOT NULL,
    FOREIGN KEY (LeagueId) REFERENCES Leagues(Id)
);

-- Create Players table
CREATE TABLE Players (
    Id INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Position NVARCHAR(20) NOT NULL
);

-- Create Matches table
CREATE TABLE Matches (
    Id INT IDENTITY PRIMARY KEY,
    HomeTeamId INT NOT NULL,
    AwayTeamId INT NOT NULL,
    MatchDate DATETIME2 NOT NULL,
    HomeTeamGoals INT NOT NULL DEFAULT 0,
    AwayTeamGoals INT NOT NULL DEFAULT 0,
    LeagueId INT NOT NULL,
    FOREIGN KEY (HomeTeamId) REFERENCES Teams(Id),
    FOREIGN KEY (AwayTeamId) REFERENCES Teams(Id),
    FOREIGN KEY (LeagueId) REFERENCES Leagues(Id)
);

-- Create PlayersTeams table (Many-to-Many Relationship)
CREATE TABLE PlayersTeams (
    PlayerId INT NOT NULL,
    TeamId INT NOT NULL,
    PRIMARY KEY (PlayerId, TeamId),
    FOREIGN KEY (PlayerId) REFERENCES Players(Id),
    FOREIGN KEY (TeamId) REFERENCES Teams(Id)
);

-- Create PlayerStats table
CREATE TABLE PlayerStats (
    PlayerId INT PRIMARY KEY,
    Goals INT NOT NULL DEFAULT 0,
    Assists INT NOT NULL DEFAULT 0,
    FOREIGN KEY (PlayerId) REFERENCES Players(Id)
);

-- Create TeamStats table
CREATE TABLE TeamStats (
    TeamId INT PRIMARY KEY,
    Wins INT NOT NULL DEFAULT 0,
    Draws INT NOT NULL DEFAULT 0,
    Losses INT NOT NULL DEFAULT 0,
    FOREIGN KEY (TeamId) REFERENCES Teams(Id)
);

-- Insert data into Leagues
INSERT INTO Leagues (Name) VALUES ('Eredivisie');

-- Insert data into Teams
INSERT INTO Teams (Name, City, LeagueId) VALUES
('PSV', 'Eindhoven', 6),
('Ajax', 'Amsterdam', 6);

-- Insert data into Players
INSERT INTO Players (Name, Position) VALUES
('Luuk de Jong', 'Forward'),
('Josip Sutalo', 'Defender');

-- Insert data into Matches
INSERT INTO Matches (HomeTeamId, AwayTeamId, MatchDate, HomeTeamGoals, AwayTeamGoals, LeagueId) VALUES
(98, 97, '2024-11-02 20:45:00', 3, 2, 6);

-- Insert data into PlayersTeams
INSERT INTO PlayersTeams (PlayerId, TeamId) VALUES
(2305, 97),
(2306, 98);

-- Insert data into PlayerStats
INSERT INTO PlayerStats (PlayerId, Goals, Assists) VALUES
(2305, 2, 0),
(2306, 2, 0);

-- Insert data into TeamStats
INSERT INTO TeamStats (TeamId, Wins, Draws, Losses) VALUES
(97, 15, 1, 3),
(98, 14, 3, 2);

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

-- Delete Players in Eredivisie and Handle Related Data
DELETE FROM PlayerStats WHERE PlayerId IN (
    SELECT p.Id FROM Players p
    JOIN PlayersTeams pt ON p.Id = pt.PlayerId
    JOIN Teams t ON pt.TeamId = t.Id
    JOIN Leagues l ON t.LeagueId = l.Id
    WHERE l.Name = 'Eredivisie' AND p.Name IN ('Luuk de Jong', 'Josip Sutalo')
);

DELETE FROM PlayersTeams WHERE PlayerId IN (
    SELECT p.Id FROM Players p
    JOIN PlayersTeams pt ON p.Id = pt.PlayerId
    JOIN Teams t ON pt.TeamId = t.Id
    JOIN Leagues l ON t.LeagueId = l.Id
    WHERE l.Name = 'Eredivisie' AND p.Name IN ('Luuk de Jong', 'Josip Sutalo')
);

DELETE FROM Players WHERE Id IN (
    SELECT p.Id FROM Players p
    JOIN PlayersTeams pt ON p.Id = pt.PlayerId
    JOIN Teams t ON pt.TeamId = t.Id
    JOIN Leagues l ON t.LeagueId = l.Id
    WHERE l.Name = 'Eredivisie' AND p.Name IN ('Luuk de Jong', 'Josip Sutalo')
);

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

-- Execute the procedure example:
-- EXEC usp_SearchTeamsByCity 'London';
