food = int(input()) * 1000

eaten_food = 0
input_string = input()

while input_string != "Adopted":
    eaten = int(input_string)
    eaten_food += eaten
    input_string = input()

if food >= eaten_food:
    print(f"Food is enough! Leftovers: {food - eaten_food} grams.")
else:
    print(f"Food is not enough. You need {eaten_food - food} grams more.")
