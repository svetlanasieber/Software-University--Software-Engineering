food_by_animal = {}
area_by_animal = {}


while True:
    line = input()
    if line == "EndDay":
        break
    command_arc = line.split(':')
    command = command_arc[0]

    if command == "Add":
        command_arc = line.split('-')

        animal = command_arc[0]
        get_animal = animal.split(':')
        animal_name = get_animal[1]
        needed_food = int(command_arc[1])
        animal_area = command_arc[2]
        if animal_name not in food_by_animal:
            food_by_animal[animal_name] = needed_food
            area_by_animal[animal_name] = animal_area
        else:
            food_by_animal[animal_name] += needed_food



    elif command == "Feed":
        command_arc = line.split('-')
        animal = command_arc[0]
        get_animal = animal.split(':')
        animal_name = get_animal[1]
        food_for_animal = int(command_arc[1])
        if animal_name in food_by_animal:
            food_by_animal[animal_name] -= food_for_animal
            if food_by_animal[animal_name] <= 0:
                print(f"{animal_name} was successfully fed")
                food_by_animal.pop(animal_name)
                area_by_animal.pop(animal_name)


print("Animals:")
for animals, food in food_by_animal.items():
    print(f"{animals} -> {food}g")
print("Areas with hungry animals:")
a = {}
for animal_lives, animal_city in area_by_animal.items():
    if animal_city not in a:
        a[animal_city] = 1
    else:
        a[animal_city] += 1
for animals, food in a.items():
    print(f"{animals}: {food}")