integers = [int(x) for x in input().split()]

while True:
    command = input()
    if command == "end":
        break

    command_args = command.split()
    command = command_args[0]

    if command in ["swap", "multiply"]:
        fst_idx, snd_idx = int(command_args[1]), int(command_args[2])
        if command == "swap":
            integers[fst_idx], integers[snd_idx] = integers[snd_idx], integers[fst_idx]
        elif command == "multiply":
            integers[fst_idx] *= integers[snd_idx]

    elif command == "decrease":
        for index in range(len(integers)):
            integers[index] -= 1

print(", ".join(str(x) for x in integers))