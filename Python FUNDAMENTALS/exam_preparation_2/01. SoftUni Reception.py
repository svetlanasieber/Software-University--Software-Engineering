first_worker = int(input())
second_worker = int(input())
third_worker = int(input())
students = int(input())
time = 0

students_per_hour = first_worker + second_worker + third_worker
if students % students_per_hour != 0:
    time = students // students_per_hour + 1
else:
    time = students // students_per_hour

if time > 3:
    if time % 3 == 0:
        time += time // 3 - 1
    else:
        time += time // 3


print(f"Time needed: {time}h.")