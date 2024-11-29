puppy_food_kg = int(input())


puppy_food_kg = puppy_food_kg * 1000

eaten_food = 0


while True:
    input_string = input()
    if input_string == "Adopted":
        break
    eaten = int(input_string)
    eaten_food += eaten


if puppy_food_kg >= eaten_food:
    print(f"Food is enough! Leftovers: {puppy_food_kg - eaten_food} grams.")
else:
    print(f"Food is not enough. You need {eaten_food - puppy_food_kg} grams more.")
