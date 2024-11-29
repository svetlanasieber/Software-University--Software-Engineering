indices_of_even_numbers = []
list_of_numbers = list(map(int, input().split(", ")))
for index in range(len(list_of_numbers)):
    current_number = list_of_numbers[index]
    if current_number % 2 == 0:
        indices_of_even_numbers.append(index)

print(indices_of_even_numbers)
