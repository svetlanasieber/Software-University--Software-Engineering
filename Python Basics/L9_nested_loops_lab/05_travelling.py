saved_money = 0

while True:
    destination = input()

    if destination == 'End':
        break

    minimum_money = float(input())
    saved_money = 0

    while saved_money < minimum_money:
        saved = float(input())
        saved_money += saved

    print(f'Going to {destination}!')
