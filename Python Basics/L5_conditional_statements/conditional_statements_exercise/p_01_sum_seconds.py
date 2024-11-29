import math

time_first = int(input())
time_second = int(input())
time_third = int(input())

#35 45 44 => 124 // 60 = 2 minuten -> ostatuk 4 secunden

total_time = time_first + time_second + time_third

minutes = total_time // 60
seconds = total_time % 60

minutes = math.floor(minutes)

# Шаблон
# print(f"{minutes}:{seconds:02}")

# ако секундите са едноцифрено число, да принтира с 0 отпред
if seconds < 10:
    print(f"{minutes}:0{seconds}")
else:
    print(f"{minutes}:{seconds}")