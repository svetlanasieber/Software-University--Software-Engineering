type_flower = input()
count_flower = int(input())
budget = int(input())
price = 0
if type_flower == "Roses":
    price = 5 * count_flower
    if count_flower > 80:
        price = price * 0.90

elif type_flower == "Dahlias":
    price = 3.80 * count_flower
    if count_flower > 90:
        price = price * 0.85

elif type_flower == "Tulips":
    price = 2.80 * count_flower
    if count_flower > 80:
        price = price * 0.85

elif type_flower == "Narcissus":
    price = 3 * count_flower
    if count_flower < 120:
        price = price * 1.15

elif type_flower == "Gladiolus":
    price = 2.50 * count_flower
    if count_flower < 80:
        price = price * 1.20
enough_budget = abs(budget - price)
if price <= budget:
    print(f"Hey, you have a great garden with {count_flower} {type_flower} and {enough_budget:.2f} leva left.")
else:
    print(F"Not enough money, you need {enough_budget:.2f} leva more.")
