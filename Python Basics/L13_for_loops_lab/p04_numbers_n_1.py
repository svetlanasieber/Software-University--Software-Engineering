# Напишете програма, която чете цяло положително число n,
# въведено от потребителя и печата числата от n до 1 в обратен ред. (namaliavame -1)
# Въведеното число n, винаги ще бъде по-голямо от 1.

number = int(input())
for current_number in range(number, 0, -1): #(start, final, step)->(number, 1 - 1, -1)
    print(current_number)