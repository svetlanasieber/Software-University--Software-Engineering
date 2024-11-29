def shoot(arr, idx, pwr):
    if 0 <= idx < len(arr):
        if arr[idx] > pwr:
            arr[idx] -= pwr
        else:
            arr.pop(idx)
    return arr


def add(arr, idx, val):
    if 0 <= idx < len(arr):
        arr.insert(idx, val)
    else:
        print(f"Invalid placement!")
    return arr


def strike(arr, idx, rad):
    if 0 <= idx - rad <= idx + rad < len(arr):
        arr = arr[:idx - rad] + arr[idx + rad + 1:]
    else:
        print("Strike missed!")
    return arr


commands = {
    "Shoot": shoot,
    "Add": add,
    "Strike": strike
}

targets = [int(x) for x in input().split()]
command = input()

while command != "End":
    action, *tokens = command.split()
    tokens = [int(x) for x in tokens]
    targets = commands[action](targets, *tokens)
    command = input()

print(*targets, sep="|")