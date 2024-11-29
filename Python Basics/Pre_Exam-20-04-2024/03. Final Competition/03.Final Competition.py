num_of_dancers = int(input())
points = float(input())
season = input()
location = input()

money_prize = 0

if location == "Bulgaria":
    money_price = points * num_of_dancers
    if season == "summer":
        money_price -= 0.05 * money_price
    elif season == "winter":
        money_price -= 0.08 * money_price
elif location == "Abroad":
    money_price = points * num_of_dancers + 0.5 * (points * num_of_dancers)
    if season == "summer":
        money_price -= 0.10 * money_price
    elif season == "winter":
        money_price -= 0.15 * money_price

charity_money = 0.75 * money_price
money_after_charity = money_price - charity_money
money_per_dancer = money_after_charity / num_of_dancers

print(f"Charity - {charity_money:.2f}")
print(f"Money per dancer - {money_per_dancer:.2f}")
