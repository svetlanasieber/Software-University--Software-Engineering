n = int(input())

if n <= 0:
    print(0)
else:
    cumulative_cons = 0


    for _ in range(n):
        daily_cons = int(input())
        cumulative_cons += daily_cons
        print(cumulative_cons)
