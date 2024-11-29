n = int(input())

ascii_sum = 0
for _ in range(n):
    letter = input()
    ascii_sum += ord(letter)

print(f"The sum equals: {ascii_sum}")
