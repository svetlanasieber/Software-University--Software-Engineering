days_of_the_week = int(input())

week = {
    1: "Monday",
    2: "Tuesday",
    3: "Wednesday",
    4: "Thursday",
    5: "Friday",
    6: "Saturday",
    7: "Sunday"
}

if days_of_the_week in range(1, 8):
    print(week[days_of_the_week])
else:
    print("Error")


# Mario Zahariev primer

number_days_of_week = int(input())

if number_days_of_week == 1:
    print("Monday")
elif number_days_of_week == 2:
    print("Tuesday")
elif number_days_of_week == 3:
    print("Wednesday")
elif number_days_of_week == 4:
    print("Thursday")
elif number_days_of_week == 5:
    print("Friday")
elif number_days_of_week == 6:
    print("Saturday")
elif number_days_of_week == 7:
    print("Sunday")
else:
    print("Error")

