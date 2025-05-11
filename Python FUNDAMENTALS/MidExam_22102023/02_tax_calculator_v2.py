def family_car(current_distance, current_years):
    current_tax = 50
    current_tax -= 5 * current_years
    multiplier = current_distance // 3000
    if current_distance >= 3000:
        current_tax += 12 * multiplier
    return current_tax


def heavy_duty_car(current_distance, current_years):
    current_tax = 80
    current_tax -= 8 * current_years
    multiplier = current_distance // 9000
    if current_distance >= 9000:
        current_tax += 14 * multiplier
    return current_tax


def sports_car(current_distance, current_years):
    current_tax = 100
    current_tax -= 9 * current_years
    multiplier = current_distance // 2000
    if distance >= 2000:
        current_tax += 18 * multiplier
    return current_tax


car_list = input().split(">>")
total_tax = 0

for car in car_list:
    command = car.split()
    type_car = command[0]
    years = int(command[1])
    distance = int(command[2])

    if type_car == "family":
        tax = family_car(distance, years)

    elif type_car == "heavyDuty":
        tax = heavy_duty_car(distance, years)

    elif type_car == "sports":
        tax = sports_car(distance, years)

    else:
        print("Invalid car type.")
        continue

    print(f"A {type_car} car will pay {tax:.2f} euros in taxes.")
    total_tax += tax

print(f"The National Revenue Agency will collect {total_tax:.2f} euros in taxes.")



