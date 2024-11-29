taxed_car = input().split('>>')
total_tax = 0
national_tax = 0
for car in taxed_car:

    car_type, tax_year, kilometers = car.split()
    tax_year = int(tax_year)
    kilometers = int(kilometers)
    car_type = str(car_type)


    if car_type == "family":
        total_tax = (kilometers // 3000) * 12 + (50 - tax_year * 5)
        national_tax += total_tax
        print(f"A {car_type} car will pay {total_tax:.2f} euros in taxes.")
    elif car_type == "heavyDuty":
        total_tax =  (kilometers // 9000) * 14 + (80 - tax_year * 8)
        national_tax += total_tax
        print(f"A {car_type} car will pay {total_tax:.2f} euros in taxes.")
    elif car_type == "sports":
        total_tax = (kilometers // 2000) * 18 + (100 - tax_year * 9)
        national_tax += total_tax
        print(f"A {car_type} car will pay {total_tax:.2f} euros in taxes.")
    else:
        print("Invalid car type.")


print(f"The National Revenue Agency will collect {national_tax:.2f} euros in taxes.")