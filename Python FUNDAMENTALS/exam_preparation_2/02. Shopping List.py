product_list = [x for x in input().split("!")]

command = input()
while not command == "Go Shopping!":
    tokens = command.split()
    command = tokens[0]
    product = tokens[1]

    if command == "Urgent":
        if product not in product_list:
            product_list.insert(0, product)
    elif command == "Unnecessary":
        if product in product_list:
            product_list.remove(product)
    elif command == "Correct":
        new_product = tokens[2]
        if product in product_list:
            index = product_list.index(product)
            product_list[index] = new_product
    elif command == "Rearrange":
        if product in product_list:
            index = product_list.index(product)
            product_list.append(product_list.pop(index))

    command = input()

print(", ".join(product_list))