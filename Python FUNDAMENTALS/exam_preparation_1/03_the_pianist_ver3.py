n = int(input())

pieces = {}
for _ in range(n):
    piece, composer, key = input().split("|")
    pieces[piece] = {"composer": composer, "key": key}

while True:
    command = input()
    if command == "Stop":
        break
    command_args = command.split("|")
    action = command_args[0]
    piece = command_args[1]
    if action == "Add":
        composer = command_args[2]
        key = command_args[3]
        if piece not in pieces:
            pieces[piece] = {"composer": composer, "key": key}
            print(f"{piece} by {composer} in {key} added to the collection!")
        else:
            print(f"{piece} is already in the collection!")
    elif action == "Remove":
        if piece in pieces:
            del pieces[piece]
            print(f"Successfully removed {piece}!")
        else:
            print(f"Invalid operation! {piece} does not exist in the collection.")
    elif action == "ChangeKey":
        new_key = command_args[2]
        if piece in pieces:
            pieces[piece]["key"] = new_key
            print(f"Changed the key of {piece} to {new_key}!")
        else:
            print(f"Invalid operation! {piece} does not exist in the collection.")

for piece, data in pieces.items():
    print(f"{piece} -> Composer: {data['composer']}, Key: {data['key']}")