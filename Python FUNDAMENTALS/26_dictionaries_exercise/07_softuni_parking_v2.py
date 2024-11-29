parking = {}
number_of_commands = int(input())

for i in range(number_of_commands):
    command = input().split()
    if command[0] == "register":
        user_name = command[1]
        license_plate = command[2]
        if user_name in parking:
            print(f"ERROR: already registered with plate number {parking[user_name]}")
        else:
            print(f"{user_name} registered {license_plate} successfully")
            parking[user_name] = license_plate
    elif command[0] == "unregister":
        user_name = command[1]
        if user_name not in parking:
            print(f"ERROR: user {user_name} not found")
        else:
            print(f"{user_name} unregistered successfully")
            del parking[user_name]

for user, plate in parking.items():
    print(f"{user} => {plate}")
