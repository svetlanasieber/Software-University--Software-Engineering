import re

valid_length = 8
validation_pattern = r"^[a-zA-Z0-9_]{8,}$"
valid_upper = False
valid_lower = False
valid_digit = False

password = input()

command = input()
while command != "Complete":
    command, *more = command.split()
    if command == "Make":
        subcommand = more[0]
        index = int(more[1])
        if 0 <= index and index < len(password):
            if subcommand == "Upper":
                password = password[:index] + password[index].upper() + password[index + 1:]
                print(password)
            elif subcommand == "Lower":
                password = password[:index] + password[index].lower() + password[index + 1:]
                print(password)
    elif command == "Insert":
        index = int(more[0])
        char = more[1]
        if 0 <= index and index < len(password):
            password = password[:index] + char +password[index:]
            print(password)
    elif command == "Replace":
        char = more[0]
        value = int(more[1])
        if char in password:
            password = password.replace(char, chr(ord(char) + value))
            print(password)
    elif command == "Validation":
        # length check
        if len(password) < 8:
            print("Password must be at least 8 characters long!")
        # symbols check
        match = re.findall(validation_pattern, password)
        if not match:
            print("Password must consist only of letters, digits and _!")
        # check for 1 upper 1 lower 1 digit
        for char in password:
            if char.isupper():
                valid_upper = True
            elif char.islower():
                valid_lower = True
            elif char.isdigit():
                valid_digit = True
        if not valid_upper:
            print("Password must consist at least one uppercase letter!")
        if not valid_lower:
            print("Password must consist at least one lowercase letter!")
        if not valid_digit:
            print("Password must consist at least one digit!")

    command = input()