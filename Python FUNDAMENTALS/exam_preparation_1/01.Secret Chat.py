# Read the concealed message
message = input()

while True:
    command = input()
    if command == "Reveal":
        break

    command_parts = command.split(":|:")
    action = command_parts[0]

    if action == "InsertSpace":
        index = int(command_parts[1])
        message = message[:index] + " " + message[index:]
        print(message)

    elif action == "Reverse":
        substring = command_parts[1]
        if substring in message:
            message = message.replace(substring, "", 1)
            reversed_substring = substring[::-1]
            message += reversed_substring
            print(message)
        else:
            print("error")

    elif action == "ChangeAll":
        substring = command_parts[1]
        replacement = command_parts[2]
        message = message.replace(substring, replacement)
        print(message)

print(f"You have a new text message: {message}")