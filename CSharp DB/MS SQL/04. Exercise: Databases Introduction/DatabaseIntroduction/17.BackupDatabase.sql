USE SoftUni

BACKUP DATABASE SoftUni TO DISK = 'D:\BackUpDB\softuni-backup.bak' 

USE master

DROP DATABASE SoftUni

RESTORE DATABASE SoftUni FROM DISK = 'D:\BackUpDB\softuni-backup.bak'

USE SoftUni