age = int(input())
washing_machine_price = float(input())
toy_price = int(input())


total_money = 0
money_gift = 10  
toys_count = 0


for i in range(1, age + 1):
    if i % 2 == 0: 
        total_money += money_gift  
        money_gift += 10 
        total_money -= 1 
    else:  
        toys_count += 1


total_money += toys_count * toy_price


if total_money >= washing_machine_price:
    print(f"Yes! {total_money - washing_machine_price:.2f}")
else:
    print(f"No! {washing_machine_price - total_money:.2f}")


