data = [x for x in input().split()]
count_of_numbers = int(input())

for _ in range(count_of_numbers):
    command_rix = input().split()
    if "Include" in command_rix:
        coffee = command_rix[1]
        data.append(coffee)
    elif "Remove" in command_rix:
        number_of_coffees = int(command_rix[2])
        if 0 <= number_of_coffees < len(data):
            index = int(command_rix[2])
            if command_rix[1] == "first":
                data = data[index:]
            elif command_rix[1] == "last":
                index = -index
                data = data[:index]
    elif "Prefer" in command_rix:
        index1, index2 = [int(x) for x in command_rix if x.isdigit()]
        if 0 <= index1 < len(data) and 0 <= index2 < len(data):
            data[index1], data[index2] = data[index2], data[index1]
    elif "Reverse" in command_rix:
        data.reverse()

print("Coffees:")
print(*data)