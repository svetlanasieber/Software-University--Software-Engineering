start_char = ord(input())
end_char = ord(input())

sequence = [ord(x) for x in input()]

total = 0
for ele in sequence:
    total += ele if start_char < ele < end_char else 0

print(total)