budget = float(input())
love_message_count = int(input())
wax_roses_count = int(input())
keychains_count = int(input())
caricature_count = int(input())
good_luck_count = int(input())

total_goods = love_message_count + wax_roses_count + keychains_count + caricature_count + good_luck_count

saved_money_1 = love_message_count * 0.6 + wax_roses_count * 7.2 + keychains_count * 3.6 + caricature_count * 18.2 + good_luck_count * 22

if total_goods >= 25:
    saved_money_1 *= 0.65

final_saved_money = saved_money_1 * 0.9

difference = abs(final_saved_money - budget)

if final_saved_money > budget:
    print(f"Yes! {difference:.2f} lv left.")
else:
    print(f"Not enough money! {difference:.2f} lv needed.")