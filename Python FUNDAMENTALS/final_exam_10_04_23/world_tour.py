def is_valid_idx(index, seq):
    return 0 <= index <= len(seq)

travel_stops = input()

while True:
    command_line = input().split(':')

    command = command_line[0]
    if command == "Travel":
        break
    if command == "Add Stop":
        input_idx = int(command_line[1])
        new_country = command_line[2]
        if is_valid_idx(input_idx, travel_stops):
            travel_stops = travel_stops[:input_idx] + new_country + travel_stops[input_idx:]
    elif command == "Remove Stop":
        start_inex = int(command_line[1])
        end_index = int(command_line[2])
        if is_valid_idx(start_inex, travel_stops) or is_valid_idx(end_index, travel_stops):
            travel_stops = travel_stops[:start_inex] + travel_stops[end_index + 1:]
    # elif command == "Switch":
    else:
        old_stop = command_line[1]
        new_stop = command_line[2]
        travel_stops = travel_stops.replace(old_stop, new_stop)

    print(travel_stops)

print(f"Ready for world tour! Planned stops: {travel_stops}")