data = input().split(" ")
bakery = {}

for i in range(0, len(data), 2):
    food = data[i]
    quantity = data[i + 1]
    bakery[food] = quantity

search_product = input().split(" ")
for product in search_product:
    if product in bakery.keys():
        print(f"We have {bakery[product]} of {product} left")
    else:
        print(f"Sorry, we don't have {product}")
