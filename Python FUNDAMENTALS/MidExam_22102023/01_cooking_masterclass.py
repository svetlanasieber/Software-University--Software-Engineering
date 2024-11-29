import math

budget_all = float(input())
students_b = int(input())
price_package_flour = float(input())
single_egg_price = float(input())
price_single_apron = float(input())

free_package_flour = students_b // 5

total_flour_price = price_package_flour * (students_b - free_package_flour)
total_eggs_price = single_egg_price * 10 * students_b
total_apron_price = price_single_apron * math.ceil(students_b * 1.2)

total_price = total_flour_price + total_eggs_price + total_apron_price

if total_price <= budget_all:
    print(f'Items purchased for {total_price:.2f}$.')
else:
    diff = abs(budget_all - total_price)
    print(f'{diff:.2f}$ more needed.')
