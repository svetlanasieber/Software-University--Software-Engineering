# градус = радиан * 180 / π.
# Числото π в Python може да достъпите чрез модула math.
# Създайте нова променлива, в която ще направите конвертирането от радиани към градуси,
# като знаете формулата за изчисление.

#import math

#radians = float(input())
#degrees = radians * 180 / math.pi

#print(degrees)

from math import pi

radians = float(input())
degrees = radians * 180 / pi

print(degrees)
