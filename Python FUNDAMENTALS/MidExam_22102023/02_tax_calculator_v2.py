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


# ------------------------------------- Another Solution -----------------------------
#
# car_list = input().split(">>")
#
# total_tax = 0
#
# for car in car_list:
#     command = car.split()
#     type_car = command[0]
#     years = int(command[1])
#     distance = int(command[2])
#
#     if type_car == "family":
#         initial_tax = 50
#         initial_tax -= 5 * years
#         multiplier = distance // 3000
#         if distance >= 3000:
#             initial_tax += 12 * multiplier
#
#     elif type_car == "heavyDuty":
#         initial_tax = 80
#         initial_tax -= 8 * years
#         multiplier = distance // 9000
#         if distance >= 9000:
#             initial_tax += 14 * multiplier
#
#     elif type_car == "sports":
#         initial_tax = 100
#         initial_tax -= 9 * years
#         multiplier = distance // 2000
#         if distance >= 2000:
#             initial_tax += 18 * multiplier
#     else:
#         print("Invalid car type.")
#         continue
#     print(f"A {type_car} car will pay {initial_tax:.2f} euros in taxes.")
#     total_tax += initial_tax
#
# print(f"The National Revenue Agency will collect {total_tax:.2f} euros in taxes.")


# ------------------------------------- Problem to resolve ------------------------------
#
# You will be given a string representing vehicles that will be taxed. Each vehicle is separated
# by ">>", where the first element is a string representing the car type, second - integer for
# the years the tax should be paid and the third - integer with kilometers traveled.
# There are 3 valid types of vehicles:
#       * family - the initial tax for a family car is 50 euros.
#       * heavyDuty - the initial tax for heavy-duty is 80 euros.
#       * sports - the initial tax for sports car is 100 euros.
# If the car is not valid print: "Invalid car type." and continue to the next vehicle.
# When calculating tax keep in mind the following rules:
#       - for family car, the tax declines by 5 euros for every year in use. Also the tax
#       increases by 12 euros for every 3000km traveled.
#       - for heavy-duty, the tax declines by 8 euros for every year in use. Also the tax
#       increases by 14 euros for every 9000km traveled.
#       - for sports car, the tax declines by 9 euros for every year in use. Also the tax
#       increases by 18 euros for every 3000km traveled.
# Input
# The possible commands are:
# "vehicle1>>vehicle2>>vehicle3…"
# "family"
# "heavyDuty"
# "sports"
# Output
# The possible outputs are:
# "Invalid car type."
# "A {car type} car will pay {total tax to pay} euros in taxes."
# "The NRA will collect {total tax collected} euros in taxes."
# Examples
# Input	                                        Output
# family 3 7210>>van 4 2345>>heavyDuty 9        A family car will pay 59.00 euros in taxes.
# 31000>>sports 4 7410	                        Invalid car type.
#                                               A heavyDuty car will pay 50.00 euros in taxes.
#                                               A sports car will pay 118.00 euros in taxes.
#                                               The NRA will collect 227.00 euros in taxes.
# --------------------------------------------------------------------------------------------
# family 5 3210>>pickUp 1 1345>>heavyDuty 7     A family car will pay 37.00 euros in taxes.
# 21000>>sports 5 9410>>family 3 9012	        Invalid car type.
#                                               A heavyDuty car will pay 52.00 euros in taxes.
#                                               A sports car will pay 127.00 euros in taxes.
#                                               A family car will pay 71.00 euros in taxes.
#                                               The NRA will collect 287.00 euros in taxes.
#
