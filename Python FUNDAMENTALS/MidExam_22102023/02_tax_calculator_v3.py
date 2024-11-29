import math

first_string_vehicles = input().split(">>")
total_tax = 0
for car in first_string_vehicles:
    type_car, yars, kilometers = car.split(' ')
    yars = int(yars)
    kilometers = int(kilometers)
    taxes = 0
    if type_car == "family":
        increase_taxes = math.floor(kilometers / 3000)
        taxes = increase_taxes * 12 + (50 - yars * 5)
        print(f"A {type_car} car will pay {taxes:.2f} euros in taxes.")
    elif type_car == "heavyDuty":
        increase_taxes = math.floor(kilometers / 9000)
        taxes = increase_taxes * 14 + (80 - yars * 8)
        print(f"A {type_car} car will pay {taxes:.2f} euros in taxes.")
    elif type_car == "sports":
        increase_taxes = math.floor(kilometers / 2000)
        taxes = increase_taxes * 18 + (100 - yars * 9)
        print(f"A {type_car} car will pay {taxes:.2f} euros in taxes.")
    else:
        print("Invalid car type.")
        continue
    total_tax += taxes
print(f"The National Revenue Agency will collect {total_tax:.2f} euros in taxes.")