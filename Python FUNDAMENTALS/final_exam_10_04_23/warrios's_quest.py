skill = input()

while True:
    command_line = input()
    if command_line == "For Azeroth":
        break
    command_line = command_line.split()

    # if len(command_line) == 4:
    #     command_line = (command_line[0] + " " + command_line[1])
    #     command = command_line
    # else:
    command = command_line[0]
    # if command == "For Azeroth":
    #     break

    if command == "GladiatorStance":
        skill = skill.upper()
        print(skill)

    elif command == "DefensiveStance":
        skill = skill.lower()
        print(skill)

    elif command == "Dispel":
        letter_index = int(command_line[1])
        letter = command_line[2]
        if letter_index <= len(skill):
            skill = skill[:letter_index] + letter + skill[letter_index+1:]
            print("Success!")
        else:
            print("Dispel too weak.")

    elif "Target"  in command_line and "Change" in command_line:
        first_str = command_line[2]
        second_str = command_line[3]
        # if skill.find(first_str):
        skill = skill.replace(first_str, second_str , 1)
        print(skill)
        # else:
        #     print(skill)

    elif "Target" in command_line and "Remove" in command_line:
        str_to_remove = command_line[2]
        if skill.find(str_to_remove):
            skill = skill.replace(str_to_remove, '')
            print(skill)
    else:
            print("Command doesn't exist!")