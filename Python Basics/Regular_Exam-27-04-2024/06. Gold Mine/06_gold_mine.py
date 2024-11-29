locations_count = int(input())

for location in range(locations_count):
    expected_average_gold = float(input())
    working_days = int(input())

    location_gr = 0

    for day in range(working_days):
        yield_per_day = float(input())
        location_gr += yield_per_day

    location_average_yield = location_gr / working_days

    if location_average_yield >= expected_average_gold:
        print(f"Good job! Average gold per day: {location_average_yield:.2f}.")
    else:
        diff = expected_average_gold - location_average_yield
        print(f"You need {diff:.2f} gold.")
