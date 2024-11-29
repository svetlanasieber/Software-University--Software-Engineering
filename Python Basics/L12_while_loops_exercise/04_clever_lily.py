
age = int(input())
washing_machine_price = float(input())
toy_price = int(input())

total_money = 0
money_gift = 10  # Starting money gift for even years
toys_count = 0

for i in range(1, age + 1):
    if i % 2 == 0:  # Even year, she receives money
        total_money += money_gift  # Add money gift to total
        money_gift += 10  # Increase the money gift for the next even year
        total_money -= 1  # Brother takes 1 unit of money
    else:  # Odd year, she receives a toy
        toys_count += 1

total_money += toys_count * toy_price

if total_money >= washing_machine_price:
    print(f"Yes! {total_money - washing_machine_price:.2f}")
else:
    print(f"No! {washing_machine_price - total_money:.2f}")
