all_stops = input()
current_stops = all_stops

command = input()

while not command == "Travel":
    split_command = command.split(":")
    real_command = split_command[0]
    if real_command == "Add Stop":
        index_add = int(split_command[1])
        string = split_command[2]
        if index_add in range(len(current_stops)):
            current_stops = current_stops[:index_add] + string + current_stops[index_add:]
    elif real_command == "Remove Stop":
        start_index = int(split_command[1])
        end_index = int(split_command[2])
        if start_index in range(len(current_stops)) and end_index in range(len(current_stops)):
            current_stops = current_stops[:start_index] + current_stops[end_index + 1:]
    elif real_command == "Switch":
        old_string = split_command[1]
        new_string = split_command[2]
        if old_string in current_stops:
            current_stops = current_stops.replace(old_string, new_string)
    print(current_stops)
    command = input()

print(f"Ready for world tour! Planned stops: {current_stops}")