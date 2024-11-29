def imitation_game():
    encrypted_message = input()

    while True:

        command = input()
        if command == 'Decode':
            break
        info = command.split("|")

        if info[0] == 'Move':
            numb_letters = int(info[1])
            moved_text = encrypted_message[:numb_letters]
            encrypted_message = encrypted_message[numb_letters:] + moved_text

        elif info[0] == 'Insert':
            index = int(info[1])
            value = info[2]

            before = encrypted_message[:index]
            after = encrypted_message[index:]
            encrypted_message = before + value + after

        elif info[0] == 'ChangeAll':
            index_to_replace = info[1]
            letter = info[2]
            encrypted_message = encrypted_message.replace(index_to_replace, letter)

    print(f'The decrypted message is: {encrypted_message}')


imitation_game()