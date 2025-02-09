CREATE TABLE Leagues (
    Id INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(50) NOT NULL
);

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