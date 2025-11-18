
month = input()
count_night = int(input())

apartment_price = 0
studio_price = 0
if month == "May" or month == "October":
    apartment_price = 65 * count_night
    studio_price = 50 * count_night

elif month == "June" or month == "September":
    apartment_price = 68.7 * count_night
    studio_price = 75.2 * count_night

elif month == "July" or month == "August":
    apartment_price = 77 * count_night
    studio_price = 76 * count_night

if count_night > 14 and (month == "May" or month ==  "October"):
    studio_price = studio_price * 0.70
elif count_night > 7 and (month == "May" or month == "October"):
    studio_price = studio_price * 0.95
elif count_night > 14 and (month == "June" or month == "September"):
    studio_price = studio_price * 0.8

if count_night > 14:
    apartment_price = apartment_price * 0.9

print(f"Apartment: {apartment_price:.2f} lv.")
print(f"Studio: {studio_price:.2f} lv.")




