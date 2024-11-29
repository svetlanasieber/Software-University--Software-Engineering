quest_days = int(input())
number_of_players = int(input())
group_energy = float(input())
water_for_person = float(input())
food_for_person = float(input())

days_count = 0
water_needed = quest_days * number_of_players * water_for_person
food_needed = quest_days * number_of_players * food_for_person
water_left = 0
food_left = 0
energy_left = group_energy
flag = False
for i in range(quest_days):
    energy_lose = float(input())
    days_count += 1
    if energy_left <= 0:
        flag = True
        break


    if days_count == 1:
        energy_left -= energy_lose

    elif days_count == 2:
        energy_left -= energy_lose
        energy_left = energy_left * 1.05
        water_needed = water_needed - (water_needed * 0.30)

    elif days_count == 3:
        days_count = 0
        energy_left -= energy_lose
        energy_left = energy_left * 1.10
        food_needed = food_needed - (food_needed / number_of_players)

if flag:
    print(f"You will run out of energy. You will be left with {food_needed:.2f} food and {water_needed:.2f} water.")
else:
    print(f"You are ready for the quest. You will be left with - {energy_left:.2f} energy!")