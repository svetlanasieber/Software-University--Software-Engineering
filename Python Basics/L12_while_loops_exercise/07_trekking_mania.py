num_groups = int(input())


total_climbers = 0
musala_climbers = 0
monblan_climbers = 0
kilimanjaro_climbers = 0
k2_climbers = 0
everest_climbers = 0


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


musala_percent = (musala_climbers / total_climbers) * 100
monblan_percent = (monblan_climbers / total_climbers) * 100
kilimanjaro_percent = (kilimanjaro_climbers / total_climbers) * 100
k2_percent = (k2_climbers / total_climbers) * 100
everest_percent = (everest_climbers / total_climbers) * 100


print(f"{musala_percent:.2f}%")
print(f"{monblan_percent:.2f}%")
print(f"{kilimanjaro_percent:.2f}%")
print(f"{k2_percent:.2f}%")
print(f"{everest_percent:.2f}%")