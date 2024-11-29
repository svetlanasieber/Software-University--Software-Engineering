encrypted_message = [input()]

def move_msg(info):
    number_of_letters = int(info[0])
    encrypted_message[0] = f"{encrypted_message[0][number_of_letters:]}{encrypted_message[0][:number_of_letters]}"

def insert_msg(info):
    index_msg, value = info
    encrypted_message[0] = f"{encrypted_message[0][:index_msg]}{value}{encrypted_message[0][index_msg:]}"

def change_all(info):
    substring, replacement = info
    encrypted_message[0] = encrypted_message[0].replace(substring, replacement)


command_func = {
    "Move": move_msg,
    "Insert": insert_msg,
    "ChangeAll": change_all
}

command = input()
while command != "Decode":
    command_type, *info = (int(x) if x.isdigit() else x for x in command.split("|"))
    command_func[command_type](info)
    command = input()

print(f"The decrypted message is: {encrypted_message[0]}")