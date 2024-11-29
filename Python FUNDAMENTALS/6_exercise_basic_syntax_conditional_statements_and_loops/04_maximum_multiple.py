# On the first line, you will be given a positive number,
# which will serve as a divisor .
# On the second line, you will receive a positive number that will be the boundary . You should find the largest integer N , that is:

# • divisible by the given divisor
# • less than or equal to the given bound
# • greater than 0

# Note: it is guaranteed that N is found.

# 1. На първия ред ще ви бъде дадено положително число, което ще служи за делител.
# 2. На втория ред ще получите положително число, което ще бъде границата.
# Трябва да намерите най-голямото цяло число N , което е:

# - делимо на дадения делител
# - по-малко или равно на дадената граница
# - по-голямо от 0

# Забележка: гарантирано е, че N е намерено.


# divisor = int(input())
# boundary = int(input())
# for number in range(boundary, divisor -1, -1):
#    if number % divisor == 0:
#        break # 99, 98, 97
# print(number)


divisor = int(input())
boundary = int(input())
for number in range(boundary, divisor - 1, -1):
    if number % divisor == 0:
        break
print(number)
