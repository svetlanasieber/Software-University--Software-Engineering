# 1
from math import ceil

number_of_students = int(input())
number_of_lectures = int(input())
additional_bonus = int(input())
max_bonus_points = 0
max_student_attendances = 0
for student in range(number_of_students):
    student_attendances = int(input())
    total_bonus = student_attendances / number_of_lectures * (5 + additional_bonus)
    if total_bonus > max_bonus_points:
        max_bonus_points = total_bonus
        max_student_attendances = student_attendances
print(f"Max Bonus: {ceil(max_bonus_points)}.")
print(f"The student has attended {max_student_attendances} lectures.")

# 2
# mu_online
# https://judge.softuni.org/Contests/Practice/Index/2028#1

rooms = input().split("|")
health = 100
bitcoins = 0
best_room = 0
you_have_been_killed = False
for room in rooms:
    best_room += 1
    command, number = room.split()
    if command == "potion":
        temp_health = health
        health += int(number)
        if health > 100:
            health = 100
        amount = health - temp_health
        print(f"You healed for {amount} hp.")
        print(f"Current health: {health} hp.")
    elif command == "chest":
        bitcoins += int(number)
        print(f"You found {number} bitcoins.")
    else:
        health -= int(number)
        if health > 0:
            print(f"You slayed {command}.")
        else:
            you_have_been_killed = True
            break
if you_have_been_killed:
    print(f"You died! Killed by {command}.")
    print(f"Best room: {best_room}")
else:
    print("You've made it!")
    print(f"Bitcoins: {bitcoins}")
    print(f"Health: {health}")

# Heart Delivery
# https://judge.softuni.org/Contests/Practice/Index/2031#2

houses = [int(house) for house in input().split("@")]
current_index = 0
command = input()
while command != "Love!":
    jump_length = int(command.split()[1])
    current_index += jump_length
    if current_index not in range(len(houses)):
        current_index = 0
    if houses[current_index] == 0:
        print(f"Place {current_index} already had Valentine's day.")
    else:
        houses[current_index] -= 2
        if houses[current_index] == 0:
            print(f"Place {current_index} has Valentine's day.")
    command = input()
print(f"Cupid's last position was {current_index}.")
if sum(houses) == 0:
    print("Mission was successful.")
else:
    houses = [int(house) for house in houses if int(house) != 0]
    print(f"Cupid has failed {len(houses)} places.")


# Heart Delivery
# https://judge.softuni.org/Contests/Practice/Index/2031#2
# V2


def cupid_gives_hearts(list_of_houses: list, cupid_index: int) -> list and int:
    if cupid_index not in range(len(list_of_houses)):
        cupid_index = 0
    if list_of_houses[cupid_index] == 0:
        print(f"Place {cupid_index} already had Valentine's day.")
    else:
        list_of_houses[cupid_index] -= 2
        if list_of_houses[cupid_index] == 0:
            print(f"Place {cupid_index} has Valentine's day.")
    return list_of_houses, cupid_index


houses = [int(house) for house in input().split("@")]
current_index = 0
command = input()
while command != "Love!":
    jump_length = int(command.split()[1])
    current_index += jump_length
    houses, current_index = cupid_gives_hearts(houses, current_index)
    command = input()
print(f"Cupid's last position was {current_index}.")
if sum(houses) == 0:
    print("Mission was successful.")
else:
    houses = [int(house) for house in houses if int(house) != 0]
    print(f"Cupid has failed {len(houses)} places.")

# validators:
#
# pylint
# flake8


# help:
# black
# formatter
# isort -> manage
# imports
