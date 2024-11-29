input_numbers = list(map(int, input().split()))

while True:
    input_command = input().split()
    command = input_command[0]
    if command == 'Finish':
        print(*input_numbers)
        break
    elif command == 'Add':
        value = int(input_command[1])
        input_numbers.append(value)
    elif command == 'Remove':
        value = int(input_command[1])
        if value in input_numbers:
            input_numbers.remove(value)
    elif command == 'Replace':
        value = int(input_command[1])
        replacement = int(input_command[2])
        if value in input_numbers:
            index = input_numbers.index(value)
            input_numbers[index] = replacement
    elif command == 'Collapse':
        value = int(input_command[1])
        input_numbers = [num for num in input_numbers if num >= value]

