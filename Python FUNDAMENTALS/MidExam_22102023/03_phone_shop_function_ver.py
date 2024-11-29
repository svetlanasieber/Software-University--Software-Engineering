def manage_phones(existing_phones, commands):
    phones = existing_phones.split(", ")

    for command in commands:
        if "Add" in command:
            phone_to_add = command.split(" - ")[1]
            if phone_to_add not in phones:
                phones.append(phone_to_add)
        elif "Remove" in command:
            phone_to_remove = command.split(" - ")[1]
            if phone_to_remove in phones:
                phones.remove(phone_to_remove)
        elif "Bonus phone" in command:
            old_phone, new_phone = command.split(" - ")[1].split(":")
            if old_phone in phones:
                phones.insert(phones.index(old_phone) + 1, new_phone)
        elif "Last" in command:
            phone_to_move_last = command.split(" - ")[1]
            if phone_to_move_last in phones:
                phones.remove(phone_to_move_last)
                phones.append(phone_to_move_last)
        elif "End" in command:
            return ", ".join(phones)

existing_phones = input()
commands = []
while True:
    command = input()
    if command == "End":
        commands.append(command)
        break
    commands.append(command)

result = manage_phones(existing_phones, commands)
print(result)