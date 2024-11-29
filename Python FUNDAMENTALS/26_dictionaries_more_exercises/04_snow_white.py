dwarfs = {}

command = input()
while command != "Once upon a time":
    name, color, physics = command.split(" <:> ")
    physics = int(physics)
    dwarfs[color] = dwarfs.get(color, {})
    dwarfs[color][name] = dwarfs[color].get(name, 0)

    if physics > dwarfs[color][name]:
        dwarfs[color][name] = physics

    command = input()

dwarfs_bridge = []

for color in dwarfs:
    for name, points in dwarfs[color].items():
        dwarfs_bridge.append(
            {
                "hat_color": len(dwarfs[color]),
                "points": points,
                "name": name,
                "color": color,
            }
        )

for info in sorted(dwarfs_bridge, key=lambda x: (-x["points"], -x["hat_color"])):
    print(f"({info['color']}) {info['name']} <-> {info['points']}")
