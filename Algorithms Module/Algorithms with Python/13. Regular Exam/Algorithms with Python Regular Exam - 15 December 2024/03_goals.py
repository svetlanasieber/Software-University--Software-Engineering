def find_best_sequence(goals):
    n = len(goals)

    dp = [1] * n
    prev = [-1] * n


    for i in range(1, n):
        for j in range(i):
            if goals[i] >= goals[j] and dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1
                prev[i] = j


    max_index = dp.index(max(dp))
    result = []


    while max_index != -1:
        result.append(goals[max_index])
        max_index = prev[max_index]

    return result[::-1]


if __name__ == "__main__":

    input_goals = input().strip()
    goals = list(map(int, input_goals.split(", ")))


    result = find_best_sequence(goals)


    print(" ".join(map(str, result)))
