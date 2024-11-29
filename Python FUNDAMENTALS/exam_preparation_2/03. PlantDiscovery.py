plants = {}
n = int(input())

for _ in range(n):
    args = input().split("<->")
    plant = args[0]
    rarity = int(args[1])
    plants[plant] = {"rarity": rarity, "rating": []}

while True:
    command = input()
    if command == "Exhibition":
        break
    command_args = command.split(": ")
    action = command_args[0]
    if action == "Rate":
        args = command_args[1].split(" - ")
        plant = args[0]
        rating = int(args[1])
        if plant not in plants:
            print("error")
        else:
            plants[plant]["rating"].append(rating)
    elif action == "Update":
        plant, new_rarity = command_args[1].split(" - ")
        if plant not in plants:
            print("error")
        else:
            plants[plant]["rarity"] = new_rarity
    elif action == "Reset":
        plant = command_args[1]
        if plant not in plants:
            print("error")
        else:
            plants[plant]["rating"].clear()

print("Plants for the exhibition:")
for plant, data in plants.items():
    rarity = data["rarity"]
    average_rating = sum(data["rating"]) / len(data["rating"]) if data["rating"] != [] else 0
    print(f"- {plant}; Rarity: {rarity}; Rating: {average_rating:.2f}")