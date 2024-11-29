# from math import floor
cat_name = input()
gender = input()

cat_months = 0

if cat_name == "British Shorthair":
    if gender == "m":
        cat_months = (13 * 12) / 6
    elif gender == "f":
        cat_months = (14 * 12) / 6
elif cat_name == "Siamese":
    if gender == "m":
        cat_months = (15 * 12) / 6
    elif gender == "f":
        cat_months = (16 * 12) / 6
elif cat_name == "Persian":
    if gender == "m":
        cat_months = (14 * 12) / 6
    elif gender == "f":
        cat_months = (15 * 12) / 6
elif cat_name == "Ragdoll":
    if gender == "m":
        cat_months = (16 * 12) / 6
    elif gender == "f":
        cat_months = (17 * 12) / 6
elif cat_name == "American Shorthair":
    if gender == "m":
        cat_months = (12 * 12) / 6
    elif gender == "f":
        cat_months = (13 * 12) / 6
elif cat_name == "Siberian":
    if gender == "m":
        cat_months = (11 * 12) / 6
    elif gender == "f":
        cat_months = (12 * 12) / 6
else:
    print(f"{cat_name} is invalid cat!")
if cat_months != 0:
    print(f"{int(cat_months)} cat months")
