start_num = int(input())
end_num = int(input())

for current_num in range(start_num, end_num + 1):
    sum_odds = 0
    sum_evens = 0
    current_num = str(current_num)
    for digit in range(len(current_num)):
        if digit % 2 == 0:
            sum_evens += int(current_num[digit])
        else:
            sum_odds += int(current_num[digit])
    if sum_odds == sum_evens:
        print(current_num, end=' ')