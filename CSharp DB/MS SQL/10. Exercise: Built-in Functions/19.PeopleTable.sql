CREATE DATABASE People2

USE People2

CREATE TABLE People 
(
	Id INT IDENTITY PRIMARY KEY,
	[Name] VARCHAR(100) NOT NULL,
	Birhtdate DATETIME NOT NULL
)

INSERT INTO People VALUES
	('Victor', '2000-12-07 00:00:00.000'),
	('Steven', '1992-09-10 00:00:00.000'),
	('Stephen', '1910-09-19 00:00:00.000'),
	('John', '2010-01-06 00:00:00.000')

SELECT [Name], 
	   DATEDIFF(YEAR, [Birhtdate], GETDATE()) AS [Age in Years], 
	   DATEDIFF(MONTH, [Birhtdate], GETDATE()) AS [Age in Months], 
	   DATEDIFF(DAY, [Birhtdate], GETDATE()) AS [Age in Days], 
	   DATEDIFF(MINUTE, [Birhtdate], GETDATE()) AS [Age in Minutes] 
  FROM People