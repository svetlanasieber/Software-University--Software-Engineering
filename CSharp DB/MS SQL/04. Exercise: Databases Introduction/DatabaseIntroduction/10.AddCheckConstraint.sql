USE Users

ALTER TABLE Users ADD CONSTRAINT CHK_PasswordIsAtLeast5Symbols CHECK (LEN([Password]) > 5)