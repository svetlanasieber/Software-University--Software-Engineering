budget = float(input())
season_type = input()


destination = ""
place = ""
price = 0
if budget <= 100:
    destination = "Bulgaria"
    if season_type == "summer":
        place = "Camp"
        price = budget * 0.3
    elif season_type == "winter":
        place = "Hotel"
        price = budget * 0.7

elif budget <= 1000:
    destination = "Balkans"
    if season_type == "summer":
            place = "Camp"
            price = budget * 0.4
    elif season_type == "winter":
            place = "Hotel"
            price = budget * 0.8
#else:
#    destination = "Europe"

elif budget > 1000:
    destination = "Europe"
    place = "Hotel"
    price = budget * 0.9

print(f"Somewhere in {destination}")
print(f"{place} - {price:.2f}")












