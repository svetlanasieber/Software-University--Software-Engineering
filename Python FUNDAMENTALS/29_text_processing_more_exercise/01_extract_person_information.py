number_of_lines = int(input())

for _ in range(number_of_lines):
    name = ""
    age = ""
    data = input()
    for index in range(len(data)):
        if data[index] == "@":
            i = 1
            while not data[index + i] == "|":
                name += data[index + i]
                i += 1
        if data[index] == "#":
            j = 1
            while not data[index + j] == "*":
                age += data[index + j]
                j += 1
    print(f"{name} is {age} years old.")