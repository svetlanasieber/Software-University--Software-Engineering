from math import pi
figure = input()
area = 0

if figure == 'square':
    side_a = float(input())
    area = side_a ** 2 # side_a * side_a or side_a ** 2

elif figure == 'rectangle':
    side_a = float(input())
    side_b = float(input())
    area = side_a * side_b

elif figure == 'circle':
    radius = float(input())
    area = pi * (radius ** 2)

elif figure == 'triangle':
    side_a = float(input())
    side_b = float(input())
    area = 1 / 2 * side_a * side_b

print(f'{area:.3f}')
