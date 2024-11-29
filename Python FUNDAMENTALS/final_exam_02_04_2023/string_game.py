start_string = input()

while True:
    line = input()
    if line == "Done":
        break
    command_arc = line.split()
    command = command_arc[0]

    if command == "Change":
        old_char = command_arc[1]
        new_char = command_arc[2]
        # if old_char in start_string:
        start_string = start_string.replace(old_char, new_char)
        print(start_string)
    elif command == "Includes":
        substring = command_arc[1]
        if start_string.find(substring) != -1:
            print("True")
        else:
            print("False")
    elif command == "End":
        substring = command_arc[1]
        if start_string.endswith(substring):
            print("True")
        else:
            print("False")
    elif command == "Uppercase":
        start_string = start_string.upper()
        print(start_string)
    elif command == "FindIndex":
        char = command_arc[1]
        char_positin = start_string.rfind(char)
        print(char_positin)
    #        / TRY THIS ONE MORE!!!
    elif command == "Cut":
        start_idx = int(command_arc[1])
        position_count = int(command_arc[2])
        chars = start_string[start_idx:start_idx + position_count]
        print(chars)