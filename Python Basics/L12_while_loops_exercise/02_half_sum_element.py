n = int(input())
nums = []
sum_numbers = 0

for _ in range(n):
    num = int(input())
    nums.append(num)
    sum_numbers += num

for num in nums:
    if num == sum_numbers - num:
        print("Yes")
        print(f"Sum = {num}")
        exit(0)

max_num = max(nums)
print("No")
print(f"Diff = {abs(max_num - (sum_numbers - max_num))}")