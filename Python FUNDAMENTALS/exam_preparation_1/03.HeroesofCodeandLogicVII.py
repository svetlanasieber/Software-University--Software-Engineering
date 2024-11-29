number_of_heroes = int(input())

all_heroes = {}

for _ in range(number_of_heroes):
    heroes_data_split = input().split()
    hero_name = heroes_data_split[0]
    if hero_name not in all_heroes:
        all_heroes[hero_name] = {'HP': 0, 'MP': 0}
    hero_hp = int(heroes_data_split[1])
    hero_mp = int(heroes_data_split[2])
    all_heroes[hero_name]['HP'] += hero_hp
    if all_heroes[hero_name]['HP'] > 100:
        all_heroes[hero_name]['HP'] = 100
    all_heroes[hero_name]['MP'] += hero_mp
    if all_heroes[hero_name]['MP'] > 200:
        all_heroes[hero_name]['MP'] = 200

command = input()

while not command == "End":
    command_split = command.split(" - ")
    real_command = command_split[0]
    if real_command == "CastSpell":
        hero_n = command_split[1]
        mp_needed = int(command_split[2])
        spell_name = command_split[3]
        if hero_n in all_heroes:
            if mp_needed <= all_heroes[hero_n]['MP']:
                all_heroes[hero_n]['MP'] -= mp_needed
                print(f"{hero_n} has successfully cast {spell_name} and now has {all_heroes[hero_n]['MP']} MP!")
            else:
                print(f"{hero_n} does not have enough MP to cast {spell_name}!")
    elif real_command == "TakeDamage":
        hero_n = command_split[1]
        damage = int(command_split[2])
        attacker = command_split[3]
        if hero_n in all_heroes:
            all_heroes[hero_n]['HP'] -= damage
            if all_heroes[hero_n]['HP'] > 0:
                print(f"{hero_n} was hit for {damage} HP by {attacker} and now has {all_heroes[hero_n]['HP']} HP left!")
            else:
                all_heroes.pop(hero_n)
                print(f"{hero_n} has been killed by {attacker}!")
    elif real_command == "Recharge":
        hero_n = command_split[1]
        amount = int(command_split[2])
        if hero_n in all_heroes:
            if all_heroes[hero_n]['MP'] + amount > 200:
                print(f"{hero_n} recharged for {200 - all_heroes[hero_n]['MP']} MP!")
                all_heroes[hero_n]['MP'] = 200
            else:
                print(f"{hero_n} recharged for {amount} MP!")
                all_heroes[hero_n]['MP'] += amount
    elif real_command == "Heal":
        hero_n = command_split[1]
        amount_hp = int(command_split[2])
        if hero_n in all_heroes:
            if all_heroes[hero_n]['HP'] + amount_hp > 100:
                print(f"{hero_n} healed for {100 - all_heroes[hero_n]['HP']} HP!")
                all_heroes[hero_n]['HP'] = 100
            else:
                print(f"{hero_n} healed for {amount_hp} HP!")
                all_heroes[hero_n]['HP'] += amount_hp

    command = input()

if all_heroes:
    # sorted_all_heroes = sorted(all_heroes.items(), key=lambda x: (-x[1]['HP'], x[0]))

    # for curr_hero, stats in sorted_all_heroes:
    for curr_hero, stats in all_heroes.items():
        print(f"{curr_hero}")
        print(f"  HP: {stats['HP']}")
        print(f"  MP: {stats['MP']}")