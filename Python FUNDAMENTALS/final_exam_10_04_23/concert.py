band_members = {}
band_playtime = {}

while True:
    line = input()
    if line == "Start!":
        break
    command_arc = line.split(';')
    command = command_arc[0]
    group_name = command_arc[1]
    artists = command_arc[2]

    if command == "Add":
        art = artists.split(',')
        if group_name not in band_members:
        # band_members[group_name] = ''
            band_members[group_name] = art

        else:
            band_members[group_name] += art


    elif command == "Play":
        if group_name not in band_playtime:
            band_playtime[group_name] = int(command_arc[2])
        else:
            band_playtime[group_name] += int(command_arc[2])

print(f"Total time: {sum(band_playtime.values())}")
for bands, playtime in band_playtime.items():
    print(f"{bands} -> {playtime}")


for band, names in band_members.items():
    print(f"=> {names}")