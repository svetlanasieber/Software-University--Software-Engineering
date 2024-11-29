encrypted_message = input()

while True:

    command_line = input()

    if command_line == "Decode":
        break

    parts = command_line.split("|")
    command = parts[0]

    if command == "Move":
        n = int(parts[1])
        encrypted_message = encrypted_message[n:] + encrypted_message[:n]
    elif command == "Insert":
        index = int(parts[1])
        value = parts[2]
        encrypted_message = encrypted_message[:index] + value + encrypted_message[index:]
    elif command == "ChangeAll":
        substring = parts[1]
        replacement = parts[2]
        encrypted_message = encrypted_message.replace(substring, replacement)


print(f"The decrypted message is: {encrypted_message}")