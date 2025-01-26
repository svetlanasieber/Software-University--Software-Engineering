CREATE TABLE NotificationEmails
(
	Id INT PRIMARY KEY IDENTITY, 
	Recipient INT REFERENCES Logs(LogId), 
	[Subject] VARCHAR(50) NOT NULL, 
	Body VARCHAR(MAX) NOT NULL
)

GO

CREATE TRIGGER tr_GenerateEmail
ON Logs FOR INSERT
AS
	DECLARE @oldSum DECIMAL(15,2) = (SELECT OldSum FROM inserted);
	DECLARE @newSum DECIMAL(15,2) = (SELECT NewSum FROM inserted);

	DECLARE	@recipient INT = (SELECT AccountId FROM inserted);
	DECLARE @subject VARCHAR(50) = 'Balance change for account: ' + CONVERT(VARCHAR(10), @recipient);
	DECLARE @body VARCHAR(MAX) = 'On ' + CONVERT(VARCHAR(MAX), GETDATE()) + ' your balance was changed from ' + CONVERT(VARCHAR(MAX), @oldSum) + ' to ' + CONVERT(VARCHAR(MAX), @newSum) + '.';

	INSERT INTO NotificationEmails(Recipient, [Subject], Body) VALUES
	(@recipient, @subject, @body);