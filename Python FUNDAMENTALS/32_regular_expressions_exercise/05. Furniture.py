import re

data = input()
pattern = r"(^>>)(?P<name>\w+)<<(?P<price>\d+(\.\d+)?)\!(?P<quantity>\d+)($|\s)"

prduct_list = []
total_price = 0

while not data == 'Purchase':
    product_info = re.match(pattern, data)

    if product_info:
        obj = product_info.groupdict()
        prduct_list.append(obj["name"])
        total_price += (float(obj["price"]) * int(obj["quantity"]))

    data = input()

print("Bought furniture:")
for product in prduct_list:
    print(product)
print(f"Total money spend: {total_price:.2f}")