hour_of_exam = int(input())
minutes_of_exam = int(input())
hour_of_arrival = int(input())
minutes_of_arrival = int(input())

time_for_exam = hour_of_exam * 60 + minutes_of_exam
time_for_arrival = hour_of_arrival * 60 + minutes_of_arrival
diff = abs(time_for_exam - time_for_arrival)
hour = diff // 60
minutes = diff % 60
if time_for_exam == time_for_arrival:
    print('On Time')

elif time_for_arrival > time_for_exam:
    print('Late')
    if diff > 59:
        print(f'{hour}:{minutes:02d} hours after the start')
    else:
        print(f'{minutes} minutes after the start')
elif time_for_arrival < time_for_exam:
    if diff <= 30:
        print('On time')
        print(f'{diff} minutes before the start')
    else:
        print('Early')
        if diff > 59:
            print(f'{hour}:{minutes:02d} hours before the start')
        else:
            print(f'{minutes} minutes before the start')
