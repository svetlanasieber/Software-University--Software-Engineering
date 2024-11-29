# •	Група до 5 човека – изкачват Мусала
# •	Група от 6 до 12 човека – изкачват Монблан
# •	Група от 13 до 25 човека – изкачват Килиманджаро
# •	Група от 26 до 40 човека –  изкачват К2
# •	Група от 41 или повече човека – изкачват Еверест

# Да се напише програма, която изчислява процента на катерачите изкачващи всеки връх.

# Вход
# От конзолата се четат поредица от числа, всяко на отделен ред:
# •	На първия ред – броя на групите от катерачи – цяло число в интервала [1...1000]
# •	За всяка една група на отделен ред – броя на хората в групата – цяло число в интервала [1...1000]

# Изход
# Да се отпечатат на конзолата 5 реда, всеки от които съдържа процент между 0.00% и 100.00% с точност до втората цифра след десетичната запетая.
# •	Първи ред - процентът изкачващи Мусала
# •	Втори ред – процентът изкачващи Монблан
# •	Трети ред – процентът изкачващи Килиманджаро
# •	Четвърти ред – процентът изкачващи К2
# •	Пети ред – процентът изкачващи Еверест

# За да решим този проблем, първо отчитаме броя на групите и след това размера на всяка група.
# Въз основа на размера на всяка група актуализираме общия брой катерачи, които се стремят към всеки връх.
# Накрая изчисляваме процентите и ги отпечатваме.

# Number of groups
num_groups = int(input())

# Total climbers and climbers for each peak
total_climbers = 0
musala_climbers = 0
monblan_climbers = 0
kilimanjaro_climbers = 0
k2_climbers = 0
everest_climbers = 0

# Read size for each group and update counts
for _ in range(num_groups):
    group_size = int(input())
    total_climbers += group_size

    if group_size <= 5:
        musala_climbers += group_size
    elif group_size >= 6 and group_size <= 12:
        monblan_climbers += group_size
    elif group_size >= 13 and group_size <= 25:
        kilimanjaro_climbers += group_size
    elif group_size >= 26 and group_size <= 40:
        k2_climbers += group_size
    else:
        everest_climbers += group_size

# Calculate percentages
musala_percent = (musala_climbers / total_climbers) * 100
monblan_percent = (monblan_climbers / total_climbers) * 100
kilimanjaro_percent = (kilimanjaro_climbers / total_climbers) * 100
k2_percent = (k2_climbers / total_climbers) * 100
everest_percent = (everest_climbers / total_climbers) * 100

# Print percentages
print(f"{musala_percent:.2f}%")
print(f"{monblan_percent:.2f}%")
print(f"{kilimanjaro_percent:.2f}%")
print(f"{k2_percent:.2f}%")
print(f"{everest_percent:.2f}%")
