
CREATE DATABASE People

USE People

CREATE TABLE People
(
	Id INT PRIMARY KEY IDENTITY,
	[Name] NVARCHAR(200) NOT NULL,
	Picture VARBINARY(MAX),
	Height FLOAT(2),
	[Weight] FLOAT(2),
	Gender CHAR(1) CHECK ([Gender] IN ('m', 'f')) NOT NULL,
	Birthdate DATE NOT NULL,
	Biography NVARCHAR(MAX)
)

INSERT INTO People VALUES
	('SomeName1', null, 1.60, 60.01, 'm', '2001/01/01', null),
	('SomeName2', null, 1.65, 65.02, 'f', '2002/02/02', null),
	('SomeName3', null, 1.70, 70.03, 'm', '2003/03/03', null),
	('SomeName4', null, 1.75, 75.04, 'f', '2004/04/04', null),
	('SomeName5', null, 1.80, 80.05, 'm', '2005/05/05', null)
