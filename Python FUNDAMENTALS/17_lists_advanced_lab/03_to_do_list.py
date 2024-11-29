todo_list = []
ten_list = []

while True:
    command = input()

    if command == "End":
        break

    ten = command.split("-")

    if ten[0] == "10":
        ten_list.append(ten[1])
        continue

    todo_list.append(command)

todo_list = sorted(todo_list)
to_do_list = [to_do.split("-")[1] for to_do in todo_list]
todo_final_list = [*to_do_list, *[ten_list[tens] for tens in range(len(ten_list))]]

print(todo_final_list)
