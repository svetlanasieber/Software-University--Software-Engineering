# 	W - ако е победител получава 2000 точки
# 	F - ако е финалист получава 1200 точки
# 	SF - ако е полуфиналист получава 720 точки
# Напишете програма, която изчислява колко ще са точките на Григор след
# изиграване на всички турнири, като знаете с колко точки стартира сезона.
# Също изчислете колко точки средно печели от всички изиграни турнири и колко процента от турнирите е спечелил.

# Вход
# От конзолата първо се четат два реда:
# •	Брой турнири, в които е участвал – цяло число в интервала [1…20]
# •	Начален брой точки в ранглистата - цяло число в интервала [1...4000]
# За всеки турнир се прочита отделен ред:
# •	Достигнат етап от турнира – текст – "W", "F" или "SF"

# Изход
# Отпечатват се три реда в следния формат:
# •	"Final points: {брой точки след изиграните турнири}"
# •	"Average points: {средно колко точки печели за турнир}"
# •	"{процент спечелени турнири}%"
# Средните точки да бъдат закръглени към най-близкото цяло число надолу,
# а процентът да се форматира до втората цифра след десетичния знак.

# За да решим този проблем, можем да прочетем броя на турнирите и началните точки от конзолата.
# След това за всеки турнир прочитаме етапа ("W", "F" или "SF") и съответно актуализираме общия брой точки.
# Можем също така да следим броя на спечелените турнири,
# за да изчислим по-късно процента на спечелените турнири.

# Number of tournaments and initial points
num_tournaments = int(input())
initial_points = int(input())

# Initialize variables to keep track of total points and wins
total_points = initial_points
wins = 0
points_earned = 0

# Process each tournament
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

# Calculate average points and winning percentage
average_points = points_earned // num_tournaments
win_percentage = (wins / num_tournaments) * 100

# Output the results
print(f"Final points: {total_points}")
print(f"Average points: {average_points}")
print(f"{win_percentage:.2f}%")
