tank_capacity = 255

n = int(input())
free_capacity = tank_capacity
for _ in range(n):
    litters_pour = int(input())
    if litters_pour > free_capacity:
        print("Insufficient capacity!")
        continue
    free_capacity -= litters_pour

print(tank_capacity - free_capacity)
