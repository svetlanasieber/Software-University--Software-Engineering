food_per_month = float(input()) * 1000  # [0.0 – 10000.0]
hay_per_month = float(input()) * 1000  # [0.0 – 10000.0]
cover_per_month = float(input()) * 1000  # [0.0 – 10000.0]
weight_per_month = float(input()) * 1000  # [0.0 – 10000.0]

is_quantity_enough = food_per_month >= 0 and hay_per_month >= 0 and cover_per_month >= 0
current_day = 0
while is_quantity_enough and current_day < 30:
    current_day += 1

    food_per_month -= 300  # daily feed guinea pig
    hay_per_month -= 0.05 * food_per_month if not current_day % 2 else 0
    cover_per_month -= weight_per_month / 3 if not current_day % 3 else 0

    is_quantity_enough = food_per_month >= 0 and hay_per_month >= 0 and cover_per_month >= 0

if is_quantity_enough:
    print(f"Everything is fine! Puppy is happy! Food: "
          f"{food_per_month / 1000:.2f}, Hay: {hay_per_month / 1000:.2f}, Cover: {cover_per_month / 1000:.2f}.")
else:
    print("Merry must go to the pet store!")