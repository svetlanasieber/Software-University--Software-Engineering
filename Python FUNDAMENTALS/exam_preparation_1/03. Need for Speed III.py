def car_info_func(info, car_dict):
    info = info.split("|")
    car = info[0]
    mileage = int(info[1])
    fuel = int(info[2])
    car_dict[car] = {'mileage': mileage, 'fuel': fuel}

    return car_dict


def drive_func(new_command, car_dict):
    car, distance, fuel = new_command[1], int(new_command[2]), int(new_command[3])
    if car in car_dict:
        if car_dict[car]['fuel'] >= fuel:
            car_dict[car]['fuel'] -= fuel
            car_dict[car]['mileage'] += distance
            print(f'{car} driven for {distance} kilometers. {fuel} liters of fuel consumed.')
            if car_dict[car]['mileage'] >= 100000:
                del car_dict[car]
                print(f'Time to sell the {car}!')
        else:
            print('Not enough fuel to make that ride')

    return car_dict


def refuel_func(new_command, car_dict):
    car, fuel = new_command[1], int(new_command[2])
    car_dict[car]['fuel'] += fuel
    if car_dict[car]['fuel'] <= 75:
        print(f'{car} refueled with {fuel} liters')

    else:
        needed_fuel = 75 - (car_dict[car]['fuel'] - fuel)
        car_dict[car]['fuel'] = 75
        print(f'{car} refueled with {needed_fuel} liters')

    return car_dict


def revert_func(new_command, car_dict):
    car, kilometers = new_command[1], int(new_command[2])
    car_dict[car]['mileage'] -= kilometers
    if car_dict[car]['mileage'] < 10000:
        car_dict[car]['mileage'] = 10000

    else:
        print(f'{car} mileage decreased by {kilometers} kilometers')

    return car_dict


def need_for_speed():
    numb = int(input())
    car_dict = {}

    for n in range(numb):
        info = input()
        car_dict = car_info_func(info, car_dict)

    while True:
        command = input()
        if command == 'Stop':
            break

        new_command = command.split(" : ")
        if new_command[0] == 'Drive':
            car_dict = drive_func(new_command, car_dict)
        elif new_command[0] == 'Refuel':
            car_dict = refuel_func(new_command, car_dict)
        elif new_command[0] == "Revert":
            car_dict = revert_func(new_command, car_dict)

    for key, value in car_dict.items():
        car = key
        mileage = value['mileage']
        fuel = value['fuel']
        print(f'{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt.')


need_for_speed()