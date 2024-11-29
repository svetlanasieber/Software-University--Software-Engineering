key = int(input())
number_of_lines = int(input())
result = []

for _ in range(number_of_lines):
    char = input()
    result.append(chr(ord(char) + key))

print("".join(result))
