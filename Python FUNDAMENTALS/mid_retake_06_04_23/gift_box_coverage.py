side_size = float(input())
sheets_number = int(input())

area_coverd = 0
total_area = 0
sheet = 0
for idx in range(sheets_number):
    paper_lenght = float(input())
    paper_width = float(input())
    sheet += 1

    total_area = side_size * side_size * 6
    if sheet % 3 == 0 and sheet != 0:
        area_coverd += paper_width * paper_lenght * 0.75
    elif sheet % 5 == 0 and sheet != 0:
        continue
    else:
        area_coverd += paper_width * paper_lenght




if area_coverd >= total_area:
    total = (total_area / area_coverd) * 100
    total = 100 - total
    print(f"You've covered the gift box!")
    print(f"{total:.2f}% wrap paper left.")

else:
    total = (area_coverd / total_area) * 100
    total = 100 - total

    print(f"You are out of paper!")
    print(f"{total:.2f}% of the box is not covered.")


# diff = abs(all_sum_amaunt - club_needed_money)