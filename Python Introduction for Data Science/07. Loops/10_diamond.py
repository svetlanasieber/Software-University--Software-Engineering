# https://judge.softuni.org/Contests/Practice/Index/1055#9

n = int(input())
for i in range(n // 2 + n % 2):
    left_right = (n - 1) // 2 - i
    mid = n - 2 * left_right - 2

    for _ in range(left_right):
        print("-", end="")

    print("*", end="")

    for _ in range(mid):
        print("-", end="")
    if mid >= 0:
        print("*", end="")

    for _ in range(left_right):
        print("-", end="")

    print()

for j in range((n - 1) // 2 - 1, -1, -1):
    left_right = (n - 1) // 2 - j
    mid = n - 2 * left_right - 2

    for _ in range(left_right):
        print("-", end="")

    print("*", end="")

    for _ in range(mid):
        print("-", end="")
    if mid >= 0:
        print("*", end="")

    for _ in range(left_right):
        print("-", end="")

    print()
