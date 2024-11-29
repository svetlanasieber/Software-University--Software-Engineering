import re

total_calories = 0

text = input()

pattern = r"([#|])(?P<item>[a-zA-Z ]+)\1(?P<exp_date>\d{2}/\d{2}/\d{2})\1(?P<calories>[0-9]{1,5})\1"

matches = re.finditer(pattern, text)
food_data = []

for match in matches:
    object_dict = match.groupdict()
    food_data.append(object_dict)
    total_calories += int(object_dict['calories'])

days_to_last = total_calories // 2000

print(f"You have food to last you for: {days_to_last} days!")

for food in food_data:
    print(f"Item: {food['item']}, Best before: {food['exp_date']}, Nutrition: {food['calories']}")