# Да се напише програма, която чете число n, въведено от потребителя,
# и печата четните степени на 2 ≤ 2n: 20, 22, 24, 26, …, 2n

# n -> final
# start -> 0
# 2 na stepen
number = int(input())
for power in range(0, number +1, 2):
    print(2 ** power)
