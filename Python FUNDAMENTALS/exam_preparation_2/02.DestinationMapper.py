import re

pattern = r"(=|/)(?P<place>[A-Z][a-zA-Z]{2,})\1"

places = input()

matches = [m.groupdict() for m in re.finditer(pattern, places)]

travel_points = 0

for pl in matches:
    travel_points += len(pl['place'])

final_places = []

for pl in matches:
    final_places.append(pl['place'])

print(f"Destinations: {', '.join(final_places)}")
print(f"Travel Points: {travel_points}")