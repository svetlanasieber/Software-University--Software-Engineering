def add_cities(dict, city, population, gold):
    if city in dict:
        dict[city]["population"] += population
        dict[city]["gold"] += gold

    else:
        dict[city] = {"population": population, "gold": gold}

    return dict


def plunder(dict, town, people, gold):
    dict[town]["population"] -= people
    dict[town]["gold"] -= gold
    print(f"{town} plundered! {gold} gold stolen, {people} citizens killed.")

    if dict[town]["population"] < 1 or dict[town]["gold"] < 1:
        print(f"{town} has been wiped off the map!")
        del dict[town]

    return dict


def prosper(dict, town, gold):
    if gold < 0:
        print("Gold added cannot be a negative number!")

    else:
        dict[town]["gold"] += gold
        print(f"{gold} gold added to the city treasury. {town} now has {dict[town]['gold']} gold.")

    return dict


cities = {}

while True:
    command = input()

    if command == "Sail":
        break

    command = command.split("||")
    city = command[0]
    population = int(command[1])
    gold = int(command[2])
    add_cities(cities, city, population, gold)

while True:
    command = input()

    if command == "End":
        break

    command = command.split("=>")
    town = command[1]

    if "Plunder" in command:
        people = int(command[2])
        gold = int(command[3])
        plunder(cities, town, people, gold)

    elif "Prosper" in command:
        gold = int(command[2])
        prosper(cities, town, gold)

if not cities:
        print("Ahoy, Captain! All targets have been plundered and destroyed!")

else:
    print(f"Ahoy, Captain! There are {len(cities)} wealthy settlements to go to:")

    for city in cities:
        print(f"{city} -> Population: {cities[city]['population']} citizens, Gold: {cities[city]['gold']} kg")