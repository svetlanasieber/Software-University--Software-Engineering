floors = int(input())
rooms = int(input())

for floor in range(floors, 0, -1):
    for room in range(rooms):
        if floor == floors:
            label = "L"
        elif floor % 2 == 0:
            label = "O"
        else:
            label = "A"

        print(f"{label}{floor}{room}", end=" ")
    print()