data = input()
bakery = {}

while data != "statistics":
    data = data.split(": ")
    product = data[0]
    quantity = int(data[1])

    if product in bakery:
        bakery[product] += quantity
    else:
        bakery[product] = quantity

    data = input()

print(f"Products in stock:")
for product in bakery:
    print(f"- {product}: {bakery[product]}")

print(f"Total Products: {len(bakery.keys())}")
print(f"Total Quantity: {sum(bakery.values())}")
