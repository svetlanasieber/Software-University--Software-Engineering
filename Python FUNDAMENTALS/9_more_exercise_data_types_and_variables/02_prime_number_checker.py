number = int(input())

is_prime = True

for divisor in range(2, int(number / 2) + 1):
    if number % divisor == 0:
        is_prime = False
        break

print(is_prime)
