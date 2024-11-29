def is_valid_index(seq, idx):
    if 0 <= idx < len(seq):
        return True
    return False


sequence = [x for x in input().split()]

moves, is_looser = 0, False
while sequence:
    command = input()
    if command == "end":
        is_looser = True
        break
    moves += 1
    command_args = command.split()
    fst_idx, snd_idx = int(command_args[0]), int(command_args[1])
    if not (is_valid_index(sequence, fst_idx) and is_valid_index(sequence, snd_idx) and not fst_idx == snd_idx):
        for _ in range(2):
            sequence.insert(len(sequence) // 2, f"-{moves}a")
        print("Invalid input! Adding additional elements to the board")
        continue
    if sequence[fst_idx] == sequence[snd_idx]:
        element = sequence[fst_idx]
        sequence[fst_idx], sequence[snd_idx] = None, None
        sequence = [x for x in sequence if x is not None]
        print(f"Congrats! You have found matching elements - {element}!")
    else:
        print("Try again!")

if is_looser:
    print(f"Sorry you lose :(\n{' '.join(sequence)}")
else:
    print(f"You have won in {moves} turns!")