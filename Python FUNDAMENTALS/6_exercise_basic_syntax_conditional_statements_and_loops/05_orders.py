# Работите в кафене и вашата задача е да подавате поръчки към дистрибуторите.
# Затова искате да знаете цената на всяка поръчка.
# На първия ред ще получите цяло число N - броят на поръчките,
# които магазинът ще получи. За всяка поръчка ще получите следната информация:

# - Цена на капсула - число с плаваща запетая в интервала [0.01.100.00]
# - Дни - цяло число в интервала [1.31]
# - Капсули, необходими на ден - цяло число в интервала [1.2000]

# За всяка поръчка трябва да отпечатате един ред в следната форма:
# - "Цената на кафето е: ${цена}"

# Ако не получите правилна поръчка (една или повече от стойностите не са в зададения диапазон),
# трябва да я игнорирате и да преминете към следващата.

# След като преминете през всички поръчки , трябва да отпечатате общата цена в следния формат:
# - "Общо: ${ total_price}"
# Както цената на кафето, така и общата цена трябва да бъдат форматирани до втория знак след десетичната запетая.

number_of_orders = int(input())
total_price = 0

for order in range(number_of_orders):
    price_per_capsule = float(input())
    days = int(input())
    amount_of_capsules_per_day = int(input())
    if price_per_capsule < 0.01 or price_per_capsule > 100:
        continue
    elif days < 1 or days > 31:
        continue
    elif amount_of_capsules_per_day < 1 or amount_of_capsules_per_day > 2000:
        continue
    price = price_per_capsule * days * amount_of_capsules_per_day
    total_price += price
    print(f"The price for the coffee is: ${price:.2f}")
print(f"Total: ${total_price:.2f}")
