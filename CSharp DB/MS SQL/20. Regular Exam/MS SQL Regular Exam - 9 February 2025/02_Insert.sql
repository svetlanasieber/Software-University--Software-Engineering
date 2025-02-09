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