energy = 100
coins = 100


def rest_event(energy_number, energy):
    if energy + energy_number > 100:
        energy_number = abs(100 - energy)

    energy += energy_number
    print(f"You gained {energy_number} energy.")
    print(f"Current energy: {energy}.")
    return energy


def order_event(coins_number, coins, energy):
    if energy - 30 >= 0:
        coins += coins_number
        energy -= 30
        print(f"You earned {coins_number} coins.")
    else:
        print("You had to rest!")
        energy += 50
    return energy, coins


def ingredient_event(name, price_item, coins):
    if price_item <= coins:
        print(f"You bought {name}.")
        coins -= price_item
        return coins

    print(f"Closed! Cannot afford {name}.")
    exit()


for event_type in main_events:
    event_type = event_type.split("-")
    event_command = event_type[0]
    event_energy_coins = int(event_type[-1])

    if event_command == "rest":
        energy = rest_event(event_energy_coins, energy)
    elif event_command == "order":
        energy, coins = order_event(event_energy_coins, coins, energy)
    else:
        coins = ingredient_event(event_command, event_energy_coins, coins)

print(f"Day completed!\nCoins: {coins}\nEnergy: {energy}")
