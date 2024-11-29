number = int(input())

num_as_list = []

for num in range(1, number + 1):
    num_as_string = str(num)
    num_as_list = [int(digit) for digit in num_as_string]
    if sum(num_as_list) == 5 or sum(num_as_list) == 7 or sum(num_as_list) == 11:
        print(f"{num} -> True")
    else:
        print(f"{num} -> False")


# 2.
# number = int(input())
# for current_number in range(1, number + 1):
#     current_number_as_string = str(current_number)
#     digits_sum = 0
#     for digit in current_number_as_string:
#         digits_sum += int(digit)
#     is_special = False
#     if digits_sum == 5 or digits_sum == 7 or digits_sum == 11:
#         is_special = True
#     print(f"{current_number} -> {is_special}")
