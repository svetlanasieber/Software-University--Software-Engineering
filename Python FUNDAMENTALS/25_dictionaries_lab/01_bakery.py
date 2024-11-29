food_and_quantity = input().split()
dict_foods = {}

for index in range(0, len(food_and_quantity) - 1, 2):
    food = food_and_quantity[index]
    quantity = int(food_and_quantity[index + 1])
    dict_foods[food] = quantity

print(dict_foods)
