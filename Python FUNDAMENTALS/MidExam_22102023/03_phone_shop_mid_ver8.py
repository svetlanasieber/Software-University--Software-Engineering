telephones_list = input().split(', ')

while True:
    command = input().split(' - ')
    if command[0] == "End":
        break
    phone = command[1]
    if command[0] == "Add":
        if phone not in telephones_list:
            telephones_list.append(phone)
    if command[0] == "Remove":
        if phone in telephones_list:
            telephones_list.remove(phone)
    if command[0] == "Bonus phone":
        old_phone, new_phone = phone.split(":")
        if old_phone in telephones_list:
            index = telephones_list.index(old_phone) + 1
            telephones_list.insert(index, new_phone)
    if command[0] == "Last":
        if phone in telephones_list:
            index = telephones_list.index(phone)
            last_phone = telephones_list.pop(index)
            telephones_list.append(last_phone)

print(', '.join(telephones_list))