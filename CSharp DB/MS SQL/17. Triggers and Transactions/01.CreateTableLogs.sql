CREATE TABLE Logs
(
	LogId INT PRIMARY KEY IDENTITY,
	AccountId INT REFERENCES Accounts(Id),
	OldSum DECIMAL(15,2) NOT NULL,
	NewSum DECIMAL(15,2) NOT NULL
)

GO

CREATE TRIGGER tr_AccountInfoIntoLogs
ON Accounts FOR UPDATE
AS
	DECLARE @accountId INT = (SELECT Id FROM deleted);
	DECLARE @oldSum DECIMAL(15,2) = (SELECT Balance FROM deleted);
	DECLARE @newSum DECIMAL(15,2) = (SELECT Balance FROM inserted);

	INSERT INTO Logs (AccountId, OldSum, NewSum) VALUES
	(@accountId, @oldSum, @newSum);
