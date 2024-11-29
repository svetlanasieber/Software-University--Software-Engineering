phone_names = input().split(", ")


while True:
    line = input()
    if line == "End":
        break
    command_name = line.split(' - ')
    command = command_name[0]
    phone = command_name[1]

    if command == "Add":
        if phone in phone_names:
            continue
        else:
            phone_names.append(phone)
    elif command == "Remove":
        if phone in phone_names:
            phone_names.remove(phone)
    elif command == "Bonus phone":
        if phone in phone_names:
            new_phone = command_name[2]
            phone_names.append(new_phone)
    elif command == "Last":
        if phone in phone_names:
            phone_names.remove(phone)
            phone_names.append(phone)

print(",".join(phone_names))