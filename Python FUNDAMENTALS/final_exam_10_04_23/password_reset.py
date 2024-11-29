input_line = input()
counter = 0
new_string = ""
while True:
    line = input()

    if line == "Done":
        break

    command_line = line.split()
    command = command_line[0]


    if command == "TakeOdd":

        for i in range(len(input_line)):
            if i % 2 != 0:
                new_string += input_line[i]
        input_line = new_string
        print(input_line)

    elif command == "Cut":
        start_idx = int(command_line[1])
        substring_length = int(command_line[2])
        input_line = input_line[:start_idx] + input_line[start_idx + substring_length:]
        print(input_line)

    elif command == "Substitute":
        substring = command_line[1]
        subtitute = command_line[2]

        if substring in input_line:
            input_line = input_line.replace(substring, subtitute)
            print(input_line)

        else:
            print(f"Nothing to replace!")

print(f"Your password is: {input_line}")