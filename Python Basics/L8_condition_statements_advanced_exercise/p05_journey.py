# •	При 100 лв. или по-малко - някъде в България:
# o	Лято - 30% от бюджета;
# o	Зима - 70% от бюджета.

# •	При 1000 лв. или по малко - някъде на Балканите:
# o	Лято - 40% от бюджета;
# o	Зима - 80% от бюджета.
# •	При повече от 1000 лв. - някъде из Европа:

# o	При пътуване из Европа, независимо от сезона, ще похарчи 90% от бюджета

# Вход
#	Бюджет - реално число;
#	Един от двата възможни сезона - "summer” или "winter”.

# Изход
# На конзолата трябва да се отпечатат два реда:
# •	 "Somewhere in [дестинация]" измежду "Bulgaria", "Balkans" и "Europe"
# •	"{Вид почивка} - {Похарчена сума}":
# o	Почивката може да е между "Camp" и "Hotel"
# o	Сумата трябва да бъде форматирана с точност до вторият знак след десетичната запетая

budget = float(input())
season_type = input()

# Първо описваме, в България, на Балканите, и в Европа е

# "summer” или "winter”.
# "Bulgaria", "Balkans" и "Europe"
# "Camp" и "Hotel"

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











