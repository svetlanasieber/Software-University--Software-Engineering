input_line = input()


while True:
    command_arc = input()

    if command_arc == "Generate":
        break

    command_line = command_arc.split(">>>")

    command = command_line[0]

    if command == "Contains":
        searched_substring = command_line[1]

        if searched_substring in input_line:
            print(f"{input_line} contains {searched_substring}.")
        else:
            print("Substring not found!")

    elif command == "Flip":
        case_sens = command_line[1]
        start_index = int(command_line[2])
        end_index = int(command_line[3])

        if case_sens == "Upper":
            upper_string = input_line[start_index:end_index].upper()
            input_line = input_line[:start_index] + upper_string + input_line[end_index:]
            print(input_line)
        elif case_sens == "Lower":
            lower_string = input_line[start_index:end_index].lower()
            input_line = input_line[:start_index] + lower_string + input_line[end_index:]
            print(input_line)

    elif command == "Slice":
        start_index = int(command_line[1])
        end_index = int(command_line[2])

        input_line = input_line[:start_index] + input_line[end_index:]
        print(input_line)

print(f"Your activation key is: {input_line}")