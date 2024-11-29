waiting_people = int(input())
lift_wagons = [int(x) for x in input().split()]

EMPTY, MAX_CAPACITY = 0, 4
slot_idx = 0
is_full = all([x == MAX_CAPACITY for x in lift_wagons])
while not is_full and waiting_people > 0:
    current_capacity = min(MAX_CAPACITY, lift_wagons[slot_idx] + waiting_people)
    amount = current_capacity - lift_wagons[slot_idx]
    lift_wagons[slot_idx] += amount
    waiting_people -= amount
    is_full = all([x == MAX_CAPACITY for x in lift_wagons])
    slot_idx += 1

if waiting_people:
    print(f"There isn't enough space! {waiting_people} people in a queue!")
elif not is_full:
    print("The lift has empty spots!")
[print(x, end=' ') for x in lift_wagons]