gifts_list = input().split()

command = input()
while command != "No Money":
    temp = command.split()
    command = temp[0]
    item = temp[1]

    if command == "OutOfStock":
        for index, current_gift in enumerate(gifts_list):
            if current_gift == item:
                gifts_list[index] = "None"

    elif command == "Required":
        index = int(temp[2])
        if 0 <= index < len(gifts_list):
            gifts_list[index] = item

    elif command == "JustInCase":
        gifts_list[-1] = item

    command = input()

while "None" in gifts_list:
    gifts_list.remove("None")

print(" ".join(gifts_list))
