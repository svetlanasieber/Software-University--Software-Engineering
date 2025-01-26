CREATE PROC usp_AssignProject(@emloyeeId INT, @projectID INT)
AS
BEGIN TRANSACTION
	DECLARE @employeeIdVerified INT = (SELECT EmployeeID FROM Employees WHERE EmployeeID = @emloyeeId);

	IF(@employeeIdVerified IS NULL)
	BEGIN
		ROLLBACK;
		THROW 50001, 'Invalid employeeId!', 1
	END;

	DECLARE @projectIdVerified INT = (SELECT ProjectID FROM Projects WHERE ProjectID = @projectID);

	IF(@projectIdVerified IS NULL)
	BEGIN
		ROLLBACK;
		THROW 50002, 'Invalid projectId!', 1
	END;

	DECLARE @countOfProjectsForTheEmployee INT = (SELECT COUNT(*) FROM EmployeesProjects WHERE EmployeeID = @emloyeeId);

	IF(@countOfProjectsForTheEmployee >= 3)
	BEGIN
		ROLLBACK;
		THROW 50003, 'The employee has too many projects!', 1
	END;

	INSERT INTO EmployeesProjects(EmployeeID, ProjectID) VALUES
		(@emloyeeId, @projectID);
COMMIT