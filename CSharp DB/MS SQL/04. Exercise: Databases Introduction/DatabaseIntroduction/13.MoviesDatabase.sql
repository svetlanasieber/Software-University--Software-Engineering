CREATE DATABASE Movies

USE Movies

CREATE TABLE Directors 
(
	Id INT PRIMARY KEY,
	DirectorName VARCHAR(30) NOT NULL,
	Notes VARCHAR(MAX)
)

INSERT INTO Directors VALUES
	(1, 'SomeName1', null),
	(2, 'SomeName2', null),
	(3, 'SomeName3', null),
	(4, 'SomeName4', null),
	(5, 'SomeName5', null)

CREATE TABLE Genres
(
	Id INT PRIMARY KEY,
	GenreName VARCHAR(20) NOT NULL,
	Notes VARCHAR(MAX)
)

INSERT INTO Genres VALUES
	(1, 'SomeGenre1', null),
	(2, 'SomeGenre2', null),
	(3, 'SomeGenre3', null),
	(4, 'SomeGenre4', null),
	(5, 'SomeGenre5', null)

CREATE TABLE Categories
(
	Id INT PRIMARY KEY,
	CategoryName VARCHAR(20) NOT NULL,
	Notes VARCHAR(MAX)
)

INSERT INTO Categories VALUES
	(1, 'SomeCategory1', null),
	(2, 'SomeCategory2', null),
	(3, 'SomeCategory3', null),
	(4, 'SomeCategory4', null),
	(5, 'SomeCategory5', null)

CREATE TABLE Movies
(
	Id INT PRIMARY KEY,
	Title VARCHAR(50) NOT NULL,
	DirectorId INT NOT NULL,
	CopyrightYear DATE NOT NULL,
	[Length] TIME NOT NULL,
	GenreId INT NOT NULL,
	CategoryId INT NOT NULL,
	Rating INT,
	Notes VARCHAR(MAX)
)

INSERT INTO Movies VALUES
	(1, 'SomeTitle1', 1, '2001/01/01', '01:01', 1, 1, null, null),
	(2, 'SomeTitle2', 2, '2002/02/02', '02:02', 2, 2, null, null),
	(3, 'SomeTitle3', 3, '2003/03/03', '03:03', 3, 3, null, null),
	(4, 'SomeTitle4', 4, '2004/04/04', '04:04', 4, 4, null, null),
	(5, 'SomeTitle5', 5, '2005/05/05', '05:05', 5, 5, null, null)