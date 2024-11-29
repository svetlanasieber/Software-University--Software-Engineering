number = int(input())

for i in range(1111, 10000):
    is_special = True
    num_to_str = str(i)
    for j in range(len(num_to_str)):
        current_num = int(num_to_str[j])
        if current_num == 0 or number % current_num != 0:
            is_special = False
            break

    if is_special:
        print(i, end=' ')