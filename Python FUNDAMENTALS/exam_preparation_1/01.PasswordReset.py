main_string = input()
command = input()

while command != "Done":
    nothing_to_replace = False
    if "TakeOdd" in command:
        main_string = main_string[1::2]
    else:
        _, index_or_substring, lenght_or_substitute = [int(x) if x.isdigit() else x for x in command.split()]
        if "Cut" in command:
            main_string = main_string[:index_or_substring] + main_string[index_or_substring + lenght_or_substitute:]
        elif "Substitute" in command:
            if index_or_substring in main_string:
                main_string = main_string.replace(index_or_substring, lenght_or_substitute)
            else:
                print("Nothing to replace!")
                nothing_to_replace = True
    if not nothing_to_replace:
        print(main_string)
    command = input()

print(f"Your password is: {main_string}")