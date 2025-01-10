----Using SQL query create table People with columns:
--•	Id – unique number for every person there will be no more than 231-1 people. (Auto incremented)
--•	Name – full name of the person will be no more than 200 Unicode characters. (Not null)
--•	Picture – image with size up to 2 MB. (Allow nulls)
--•	Height –  In meters. Real number precise up to 2 digits after floating point. (Allow nulls)
--•	Weight –  In kilograms. Real number precise up to 2 digits after floating point. (Allow nulls)
--•	Gender – Possible states are m or f. (Not null)
--•	Birthdate – (Not null)
--•	Biography – detailed biography of the person it can contain max allowed Unicode characters. (Allow nulls)
--Make Id primary key. Populate the table with only 5 records. Submit your CREATE and INSERT statements as Run queries & check DB.


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