budget = float(input())
season = str(input())

destination = ""

if budget <= 100:
    destination = 'Bulgaria'
    if season == 'summer':
        type_of_trip = 'Camp'
        trip_expense = budget * 0.30
    elif season == 'winter':
        type_of_trip = 'Hotel'
        trip_expense = budget * 0.70
elif 100 < budget <= 1000:
    destination = 'Balkans'
    if season == 'summer':
        type_of_trip = 'Camp'
        trip_expense = budget * 0.40
    elif season == 'winter':
        type_of_trip = 'Hotel'
        trip_expense = budget * 0.80
elif budget > 1000:
    destination = 'Europe'
    type_of_trip = 'Hotel'
    trip_expense = budget * 0.90

if destination:
    print(f"Somewhere in {destination}")
    print(f"{type_of_trip} - {trip_expense:.2f}")
