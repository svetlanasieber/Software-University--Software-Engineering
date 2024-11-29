def tribonacci_sequence(some_number):
    tribonacci_seq = []
    for i in range(1, some_number + 1):
        if i == 1:
            tribonacci_seq.append(i)
        elif i <= 3:
            tribonacci_seq.append(i - 1)
        else:
            tribonacci_seq.append(
                tribonacci_seq[i - 4] + tribonacci_seq[i - 3] + tribonacci_seq[i - 2]
            )
    print(*tribonacci_seq)


number_of_digits = int(input())
tribonacci_sequence(number_of_digits)
