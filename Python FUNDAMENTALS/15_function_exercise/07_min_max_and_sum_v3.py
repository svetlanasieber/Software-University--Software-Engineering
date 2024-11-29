sum_of_numbers = 0
list_of_numbers_as_string = input().split(" ")
list_of_numbers_as_digits = list(map(int, list_of_numbers_as_string))

min_number = min(list_of_numbers_as_digits)
max_number = max(list_of_numbers_as_digits)

for number in list_of_numbers_as_string:
    sum_of_numbers += int(number)

print(f"The minimum number is {min_number}")
print(f"The maximum number is {max_number}")
print(f"The sum number is: {sum_of_numbers}")
