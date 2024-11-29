def processing(line_one, line_two):
    result = 0
    if line_one == "int":
        result = int(line_two) * 2
        return result
    elif line_one == "real":
        result = float(line_two) * 1.5
        return f"{result:.2f}"
    elif line_one == "string":
        result = f"${line_two}$"
        return result


first_line = input()
second_line = input()

print(processing(first_line, second_line))
