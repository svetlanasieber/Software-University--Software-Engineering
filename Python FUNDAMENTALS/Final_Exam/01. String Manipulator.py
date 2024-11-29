string = input()

while True:
    cmd = input().split()
    command = cmd[0]
    if command == 'End':
        exit()
    if command == 'Translate':
        char = cmd[1]
        replacement = cmd[2]
        string = string.replace(char, replacement)
        print(string)
    elif command == 'Includes':
        string_var = cmd[1]
        if string_var in string:
            print('True')
        else:
            print('False')
    elif command == 'Start':
        string_var = cmd[1]
        if string.startswith(string_var):
            print('True')
        else:
            print('False')
    elif command == 'Lowercase':
        string = string.lower()
        print(string)
    elif command == 'FindIndex':
        char = cmd[1]
        if char in string:
            print(string.rindex(char))
    elif command == 'Remove':
        start_index = int(cmd[1])
        count = int(cmd[2])
        string = string[:start_index] + string[start_index+count:]
        print(string)