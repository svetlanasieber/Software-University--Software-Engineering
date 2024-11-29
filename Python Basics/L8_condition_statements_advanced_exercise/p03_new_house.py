flower_type = input()  # Въвеждане на вид цветя
flower_count = int(input())  # Въвеждане на броя цветя
budget = int(input())  # Въвеждане на бюджета

flower_prices = {
    "Roses": 5.00,
    "Dahlias": 3.80,
    "Tulips": 2.80,
    "Narcissus": 3.00,
    "Gladiolus": 2.50
}

flower_cost = flower_count * flower_prices[flower_type]  # Изчисляване на цената за цветята

if flower_type == "Roses" and flower_count > 80:
    flower_cost *= 0.90
elif flower_type == "Dahlias" and flower_count > 90:
    flower_cost *= 0.85
elif flower_type == "Tulips" and flower_count > 80:
    flower_cost *= 0.85
elif flower_type == "Narcissus" and flower_count < 120:
    flower_cost *= 1.15
elif flower_type == "Gladiolus" and flower_count < 80:
    flower_cost *= 1.20

if flower_cost <= budget:
    remaining_budget = budget - flower_cost
    print(f"Hey, you have a great garden with {flower_count} {flower_type} and {remaining_budget:.2f} leva left.")
else:
    needed_money = flower_cost - budget
    print(f"Not enough money, you need {needed_money:.2f} leva more.")