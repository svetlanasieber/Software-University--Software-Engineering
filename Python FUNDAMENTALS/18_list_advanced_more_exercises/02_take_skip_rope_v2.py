string = input()
numbers = []
non_numbers = []
take_list = []
skip_list = []

for letter in string:
    if letter.isdigit():
        numbers.append(int(letter))
    else:
        non_numbers.append(letter)

for index, number in enumerate(numbers):
    if index % 2 != 0:
        skip_list.append(number)
    else:
        take_list.append(number)

skipped_string = ""
taken_string = ""
non_numbers = "".join(non_numbers)
non_numbers_count = 0

for num1, num2 in zip(skip_list, take_list):
    taken_string += non_numbers[:num2]
    non_numbers = non_numbers[num2:]
    non_numbers = non_numbers[num1:]
    non_numbers_count += num1

print(taken_string)
