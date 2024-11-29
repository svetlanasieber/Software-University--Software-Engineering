numbers = [int(el) for el in input().split()]
new_list = []

for num in numbers:
    if num > sum(numbers) / len(numbers):
        new_list.append(num)
new_list.sort()
new_list.reverse()

new_list = [str(i) for i in new_list]

print(' '.join(new_list[:5]))

if len(new_list) == 0:
    print("No")