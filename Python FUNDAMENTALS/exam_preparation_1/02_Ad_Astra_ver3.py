import re

text_string = input()

pattern = r"(\||#)(?P<item>[a-zA-z\s]+)\1(?P<date>\d{2}/\d{2}/\d{2})\1(?P<calories>([0-9]{1,4}|10000))\1"

total_calories = 0

matched_foods = [el.groupdict() for el in re.finditer(pattern, text_string)]

for food in matched_foods:
    total_calories += int(food['calories'])

days = total_calories // 2000

print(f"You have food to last you for: {days} days!")

for match in matched_foods:
    print(f"Item: {match['item']}, Best before: {match['date']}, Nutrition: {match['calories']}")