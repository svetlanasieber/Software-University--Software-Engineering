raw_activation_key = input()

while True:

    command_line = input()

    # Terminate the loop if the command is "Generate"
    if command_line == "Generate":
        break

    # Parse the command
    command_parts = command_line.split(">>>")
    command_type = command_parts[0]

    # Execute the command according to its type
    if command_type == "Contains":
        substring = command_parts[1]
        if substring in raw_activation_key:
            print(f"{raw_activation_key} contains {substring}")
        else:
            print("Substring not found!")

    elif command_type == "Flip":
        case = command_parts[1]
        start_index = int(command_parts[2])
        end_index = int(command_parts[3])

        if case == "Upper":
            raw_activation_key = raw_activation_key[:start_index] + raw_activation_key[
                                                                    start_index:end_index].upper() + raw_activation_key[
                                                                                                     end_index:]
        else:  # case == "Lower"
            raw_activation_key = raw_activation_key[:start_index] + raw_activation_key[
                                                                    start_index:end_index].lower() + raw_activation_key[
                                                                                                     end_index:]

        print(raw_activation_key)

    elif command_type == "Slice":
        start_index = int(command_parts[1])
        end_index = int(command_parts[2])

        raw_activation_key = raw_activation_key[:start_index] + raw_activation_key[end_index:]
        print(raw_activation_key)

print(f"Your activation key is: {raw_activation_key}")