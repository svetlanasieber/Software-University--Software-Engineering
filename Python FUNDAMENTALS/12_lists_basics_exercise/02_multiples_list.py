first_number = int(input())
first_number_cnt = first_number
second_number = int(input())
list_numbers = []

for multiply in range(1, second_number + 1):
    list_numbers.append(first_number_cnt)

    first_number_cnt += first_number

print(list_numbers)
