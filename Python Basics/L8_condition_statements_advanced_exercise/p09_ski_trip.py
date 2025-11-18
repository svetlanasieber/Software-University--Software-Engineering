days = int(input())
type_of_the_room = input()
value_positiv_or_negative = input()


nights = days - 1
price_per_night = 0

if type_of_the_room == "room for one person":
    price_per_night = 18

elif type_of_the_room == "apartment":
    price_per_night = 25
    if nights < 10:
        price_per_night *= 0.7
    elif nights <= 15:
        price_per_night *= 0.65 # 100 - 35 = 65
    elif nights > 15: # else:
        price_per_night *= 0.5

elif type_of_the_room == "president apartment": #else
    price_per_night = 35
    if nights < 10:
        price_per_night *= 0.9
    elif nights <= 15:
        price_per_night *= 0.85
    elif nights > 15:  # else:
        price_per_night *= 0.8
total_sum = nights * price_per_night

if value_positiv_or_negative == "positive":
    total_sum *= 1.25
elif value_positiv_or_negative == "negative":
    total_sum *= 0.9

print(f"{total_sum:.2f}")









