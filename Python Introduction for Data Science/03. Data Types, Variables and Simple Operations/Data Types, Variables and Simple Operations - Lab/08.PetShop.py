dog_food_packages = int(input())
cat_food_packages = int(input())

dog_foods_cost = 2.50
cat_foods_cost = 4

dog_foods_total = dog_food_packages * dog_foods_cost
cat_foods_total = cat_food_packages * cat_foods_cost

total_cost = dog_foods_total + cat_foods_total
print(f"{total_cost} lv.")