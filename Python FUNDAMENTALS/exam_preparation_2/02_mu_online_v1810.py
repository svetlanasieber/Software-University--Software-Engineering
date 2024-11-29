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
