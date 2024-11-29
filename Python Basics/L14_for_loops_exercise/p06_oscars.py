# •	Име на актьора - текст
# •	Точки от академията - реално число в интервала [2.0... 450.5]
# •	Брой оценяващи n - цяло число в интервала[1… 20]

# На следващите n-на брой реда:
# o	Име на оценяващия - текст
# o	Точки от оценяващия - реално число в интервала [1.0... 50.0]

# Изход
# Да се отпечата на конзолата един ред:
# •	Ако точките са над 1250.5:
# "Congratulations, {име на актьора} got a nominee for leading role with {точки}!"
# •	Ако точките не са достатъчни:
# 	"Sorry, {име на актьора} you need {нужни точки} more!"

# Резултатът да се форматирана до първата цифра след десетичния знак!

# За да решите този проблем, можете да използвате Python,
# за да изчислите точките на актьора въз основа на дадената формула.
# Прочетете името на актьора, началните точки от академията и броя на оценителите.
# След това направете цикъл през всеки оценител, за да изчислите точките.

# Input for actor name and initial points
actor_name = input()
initial_points = float(input())
num_evaluators = int(input())

# Loop through the evaluators to calculate points
for _ in range(num_evaluators):
    evaluator_name = input()
    evaluator_points = float(input())

    points_from_evaluator = (len(evaluator_name) * evaluator_points) / 2
    initial_points += points_from_evaluator

    # Check if the points exceed 1250.5
    if initial_points > 1250.5:
        print(f"Congratulations, {actor_name} got a nominee for leading role with {initial_points:.1f}!")
        break
else:
    # If points are not sufficient
    points_needed = 1250.5 - initial_points
    print(f"Sorry, {actor_name} you need {points_needed:.1f} more!")
