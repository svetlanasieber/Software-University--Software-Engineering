list_numbers = map(int, input().split(" "))

even_numbers = list(filter(lambda x: x % 2 == 0, list_numbers))

print(even_numbers)