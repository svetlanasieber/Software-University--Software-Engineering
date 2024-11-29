line_number = int(input())

plants = {}
plants_spec = {}
for _ in range(line_number):
    plant_name = input().split('<->')
    name = plant_name[0]
    rarity = int(plant_name[1])
    raiting = 0

    plants[name] = rarity
    plants_spec[name] = raiting

while True:
    line = input()

    if line == "Exhibition":
        break
    command_line = line.split(':')

    command = command_line[0]
    command_arg = command_line[1]
    to_do = command_arg.split(' -')
    name = to_do[0]


    if command == "Rate":
        rarity_or_reiting = int(to_do[1])
        plants_spec[name] += rarity_or_reiting
    elif command == "Update":
        if name in plants:
            rarity_or_reiting = int(to_do[1])
            plants[name] = rarity_or_reiting
    elif command == "Reset":
        if name in plants:
            plants_spec[name] = 0
print(plants, plants_spec)