days_of_vacation = int(input())
type_of_room = input()
grade = input()

nights_on_vacation = days_of_vacation - 1

price = 0
discount = 1
total_price = 0

ROOM_FOR_ONE_PERSON = 18
APARTMENT = 25
PRESIDENT_APARTMENT = 35

if type_of_room == 'room for one person':
    price = nights_on_vacation * ROOM_FOR_ONE_PERSON


elif type_of_room == 'apartment':
    price = nights_on_vacation * APARTMENT
    if days_of_vacation < 10:
        discount = 0.70
    elif 10 <= nights_on_vacation <= 15:
        discount = 0.65
    elif nights_on_vacation > 15:
        discount = 0.50

elif type_of_room == 'president apartment':
    price = nights_on_vacation * PRESIDENT_APARTMENT
    if nights_on_vacation < 10:
        discount = 0.90
    elif 10 == nights_on_vacation <= 15:
        discount = 0.85
    elif nights_on_vacation > 15:
        discount = 0.80

if grade == 'positive':
    price = (price + price * 0.25) * discount
elif grade == 'negative':
    price = (price - price * 0.10) * discount

print(f"{price:.2f}")
