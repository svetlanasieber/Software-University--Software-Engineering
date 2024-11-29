collection_items = input().split("|")
budget = int(input())

profit = 0
condition = False
new_item_price = []
data_item_price = []

for item in collection_items:
    type_item = item.split("->")
    items = type_item[0]
    item_value = float(type_item[1])
    condition = False

    if items == "Clothes":
        if item_value <= 50:
            condition = True
    elif items == "Shoes":
        if item_value <= 35:
            condition = True
    elif items == "Accessories":
        if item_value <= 20.50:
            condition = True

    if condition:
        if budget >= item_value:
            budget -= item_value
            profit += item_value * 0.4
            new_price = item_value + (item_value * 0.40)
            new_item_price.append(new_price)
            data_item_price.append(f"{new_price:.2f}")

print(" ".join(data_item_price))
print(f"Profit: {profit:.2f}")
new_budget = sum(new_item_price) + budget
if new_budget >= 150:
    print(f"Hello, France!")
else:
    print(f"Not enough money.")
