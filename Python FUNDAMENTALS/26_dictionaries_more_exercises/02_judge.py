result = {}
individual_standings = {}

while True:
    command = input()

    if command == "no more time":
        break

    username, contest, points = command.split(" -> ")
    points = int(points)

    if contest not in result:
        result[contest] = {username: points}
    if username not in result[contest]:
        result[contest][username] = points
    if result[contest][username] < points:
        result[contest][username] = points

for contest, username in result.items():
    print(f"{contest}: {len(username)} participants")

    for index in range(len(username)):
        sorted_points = sorted(username.items(), key=lambda sort: (-sort[1], sort[0]))
        print(f"{index + 1}. {sorted_points[index][0]} <::> {sorted_points[index][1]}")

        if sorted_points[index][0] not in individual_standings:
            individual_standings[sorted_points[index][0]] = sorted_points[index][1]

        else:
            individual_standings[sorted_points[index][0]] += sorted_points[index][1]

sorted_individual_standings = sorted(
    individual_standings.items(), key=lambda points: (-points[1], points[0])
)

print("Individual standings:")

for index in range(len(sorted_individual_standings)):
    print(
        f"{index + 1}. {sorted_individual_standings[index][0]} -> {sorted_individual_standings[index][1]}"
    )
