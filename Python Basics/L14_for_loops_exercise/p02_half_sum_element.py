import sys

n = int(input())


numbers = [int(input()) for _ in range(n)]

total_sum = sum(numbers)

found = False


for num in numbers:
    if num == total_sum - num:
        print("Yes")
        print(f"Sum = {num}")
        found = True
        break


if not found:
    max_num = max(numbers)
    print("No")
    print(f"Diff = {abs(max_num - (total_sum - max_num))}")




