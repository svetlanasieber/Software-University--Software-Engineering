start_char = int(input())
last_char = int(input())

for ch in range(start_char, last_char + 1):
    print(f"{chr(ch)}", end=" ")
