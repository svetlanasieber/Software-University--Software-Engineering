# doesnt work

solve_string = input()

while True:
    command = input().split()
    current_command = command[0]
    if current_command == "End":
        break
    elif current_command == 'Translate':
        char = command[1]
        replacement = command[2]
        translated_string = solve_string.replace(char, replacement)
        print(translated_string)
    elif current_command == 'Includes':
        substring = command[1]
        if substring in solve_string:
            print('True')
        else:
            print('False')
    elif current_command == 'Start':
        second_substring = command[1]
        if solve_string.startswith(second_substring):
            print('True')
        else:
            print('False')
    elif current_command == 'Lowercase':
        lower_case_string = solve_string.lower()
        print(lower_case_string)
    elif current_command == 'FindIndex':
        second_char = command[1]
        last_seen_index_char = solve_string.rindex(second_char)
    elif current_command == 'Remove':
        start_index = command[1]
        count = command[2]
        new_string = solve_string[int(start_index):int(count)]
        print(new_string)