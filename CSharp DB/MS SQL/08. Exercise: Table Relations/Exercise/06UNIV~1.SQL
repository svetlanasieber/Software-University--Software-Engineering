CREATE DATABASE UniversityDatabase
GO

USE UniversityDatabase

CREATE TABLE Majors
(
	MajorID INT IDENTITY PRIMARY KEY,
	[Name] VARCHAR(50) NOT NULL
)

CREATE TABLE Students
(
	StudentID INT IDENTITY PRIMARY KEY,
	StudentNumber CHAR(4) NOT NULL,
	StudentName VARCHAR(25) NOT NULL,
	MajorID INT REFERENCES Majors(MajorID)
)

CREATE TABLE Payments
(
	PaymentID INT IDENTITY PRIMARY KEY,
	PaymentDate DATE NOT NULL,
	PaymentAmount DECIMAL(10,2) NOT NULL,
	StudentID INT REFERENCES Students(StudentID)
)

CREATE TABLE Subjects
(
	SubjectID INT IDENTITY PRIMARY KEY,
	SubjectName VARCHAR(50) NOT NULL
)

CREATE TABLE Agenda
(
	StudentID INT REFERENCES Students(StudentID),
	SubjectID INT REFERENCES Subjects(SubjectID),

	CONSTRAINT PK_Students_Subjects PRIMARY KEY(StudentID, SubjectID)
)