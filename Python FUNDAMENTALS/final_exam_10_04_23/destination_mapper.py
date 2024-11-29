import re

countryes = input()
dest = []
points = 0
pattern = re.findall(r"([=|/])\b([A-Z][A-Za-z]+)\1", countryes)

for destination in pattern:
    points += len(destination[1])
    dest.append(destination[1])

print(f"Destinations: {', '.join(dest)}")
print(f"Travel Points: {points}")