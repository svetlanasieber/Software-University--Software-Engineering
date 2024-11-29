# quantity = int(input())
# days = int(input())

# ornament_set = 2
# tree_skirt = 5
# tree_garlands = 3
# tree_lights = 15

# christmas_spirit = 0
# budget = 0

# for day in range(1, days + 1):
#    if day % 11 == 0:
#        quantity += 2

#    if day % 10 == 0:
#        christmas_spirit -= 20
#        budget += tree_skirt + tree_lights + tree_garlands

#       if day == days:
#            christmas_spirit -= 30

#    if day % 5 == 0:
#        christmas_spirit += 17
#        budget += tree_lights * quantity

#    if day % 15 == 0:
#        christmas_spirit += 30 # fifth day with garlands

#    if day % 3 == 0:
#        christmas_spirit += 13
#        budget += (tree_garlands + tree_skirt) * quantity

#    if day % 2 == 0:
#        christmas_spirit += 5
#        budget += ornament_set * quantity

# print(f"Total cost: {budget}")
# print(f"Total spirit: {christmas_spirit}")



quantity_of_decorations = int(input())
remaining_days = int(input())
ornament_set_price = 2
tree_skirt_price = 5
tree_garland_price = 3
tree_lights_price = 15
total_spirit = 0
total_cost = 0
for current_day in range(1, remaining_days + 1):
    if current_day % 11 == 0:
        quantity_of_decorations += 2
    if current_day % 2 == 0:
        total_cost += quantity_of_decorations * ornament_set_price
        total_spirit += 5
    if current_day % 3 == 0:
        total_cost += quantity_of_decorations * (tree_skirt_price + tree_garland_price)
        total_spirit += 10 + 3
    if current_day % 5 == 0:
        total_cost += quantity_of_decorations * tree_lights_price
        total_spirit += 17
        if current_day % 3 == 0:
            total_spirit += 30
    if current_day % 10 == 0:
        total_spirit -= 20
        total_cost += tree_skirt_price + tree_garland_price + tree_lights_price
if remaining_days % 10 == 0:
    total_spirit -= 30
print(f"Total cost: {total_cost}")
print(f"Total spirit: {total_spirit}")
