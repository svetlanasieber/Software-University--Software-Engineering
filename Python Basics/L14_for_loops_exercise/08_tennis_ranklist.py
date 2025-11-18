num_tournaments = int(input())
initial_points = int(input())


total_points = initial_points
wins = 0
points_earned = 0


for _ in range(num_tournaments):
    stage = input()
    if stage == 'W':
        total_points += 2000
        points_earned += 2000
        wins += 1
    elif stage == 'F':
        total_points += 1200
        points_earned += 1200
    elif stage == 'SF':
        total_points += 720
        points_earned += 720


average_points = points_earned // num_tournaments
win_percentage = (wins / num_tournaments) * 100


print(f"Final points: {total_points}")
print(f"Average points: {average_points}")
print(f"{win_percentage:.2f}%")

