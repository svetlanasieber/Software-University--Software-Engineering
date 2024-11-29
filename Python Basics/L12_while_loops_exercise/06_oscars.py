actor_name = input()
initial_points = float(input())
num_evaluators = int(input())

for _ in range(num_evaluators):
    evaluator_name = input()
    evaluator_points = float(input())

    points_from_evaluator = (len(evaluator_name) * evaluator_points) / 2
    initial_points += points_from_evaluator

    if initial_points > 1250.5:
        print(f"Congratulations, {actor_name} got a nominee for leading role with {initial_points:.1f}!")
        break
else:

    points_needed = 1250.5 - initial_points
    print(f"Sorry, {actor_name} you need {points_needed:.1f} more!")