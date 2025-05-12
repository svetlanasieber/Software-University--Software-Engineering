from math import floor

width_of_the_ship = float(input())
length_of_the_ship = float(input())
height_of_the_ship = float(input())
height_of_the_astronauts = float(input())
rocket_space = width_of_the_ship * length_of_the_ship * height_of_the_ship
room_space = (height_of_the_astronauts + 0.40) * 2 * 2

total_room_space = floor(rocket_space / room_space)


if 3 <= total_room_space <= 10:
    print(f"The spacecraft holds {total_room_space} astronauts.")
elif total_room_space < 3:
    print("The spacecraft is too small.")
elif total_room_space > 10:
    print("The spacecraft is too big.")
