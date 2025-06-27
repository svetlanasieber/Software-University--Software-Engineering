speed = float(input())
display = ""

if speed <= 10:
    display = "slow"

elif 10 < speed <= 50:
    display = "average"

elif 50 < speed <= 150:
    display = "fast"

elif 150 < speed <= 1000:
    display = "ultra fast"

elif speed > 1000:
    display = "extremely fast"

print(display)
