CREATE PROC usp_WithdrawMoney (@accountId INT, @moneyAmount DECIMAL(15,4))
AS
BEGIN TRANSACTION
	DECLARE @accountIdVerified INT = (SELECT Id FROM Accounts WHERE Id = @accountId);

	IF(@accountIdVerified IS NULL)
	BEGIN
		ROLLBACK;
		THROW 50001, 'Invalid account id!', 1;
	END

	IF(@moneyAmount < 0)
	BEGIN
		ROLLBACK;
		THROW 50002, 'Money amount can not be negative!', 1
	END

	DECLARE @accountBalance DECIMAL(15,4) = (SELECT Balance FROM Accounts WHERE Id = @accountId);

	IF(@accountBalance < @moneyAmount)
	BEGIN
		ROLLBACK;
		THROW 50003, 'Not enough money!', 1;
	END

	UPDATE Accounts
	   SET Balance -= @moneyAmount
	 WHERE Id = @accountId;
COMMIT