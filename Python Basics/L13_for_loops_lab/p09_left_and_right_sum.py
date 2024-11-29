# 9.	Лява и дясна сума
# Да се напише програма, която чете 2 * n-на брой цели числа, подадени от потребителя,
# и проверява дали сумата на първите n числа (лява сума) е равна на сумата на вторите n числа (дясна сума).
# При равенство печата "Yes, sum = " + сумата; иначе печата "No, diff = " + разликата.
# Разликата се изчислява като положително число (по абсолютна стойност -abs()).

count_of_numbers = int(input())
left_sum = 0
right_sum = 0
for numbers in range(count_of_numbers * 2):
    current_number = int(input())
    if numbers < count_of_numbers:
        left_sum += current_number
    else:
        right_sum += current_number
if left_sum == right_sum:
        print(f"Yes, sum = {left_sum}")
else:
    difference = abs(left_sum - right_sum)
    print(f"No, diff = {difference}") #abs ni e razlikata


# vtori variant
range_numbers = int(input())

left_sum = 0
right_sum = 0

'''
0 1 2 3
'''
for number in range(range_numbers * 2):
    number_to_add = int(input())
    if number < range_numbers:
        left_sum += number_to_add
    elif number >= range_numbers:
        right_sum += number_to_add

# for left in range(range_numbers):
#     left_sum += int(input())
#
# for right in range(range_numbers):
#     right_sum += int(input())


if left_sum == right_sum:
    print(f"Yes, sum = {left_sum}")
else:
    diff = abs(left_sum - right_sum)
    print(f"No, diff = {diff}")