#	Ако фигурата е квадрат (square): на следващия ред се чете едно дробно число - дължина на страната му
#	Ако фигурата е правоъгълник (rectangle): на следващите два реда четат две дробни числа - дължините на страните му
#	Ако фигурата е кръг (circle): на следващия ред чете едно дробно число - радиусът на кръга
#	Ако фигурата е триъгълник (triangle):
#	на следващите два реда четат две дробни числа -
#	дължината на страната му и дължината на височината към нея

import math
fig_type = input()

if fig_type == "square":
    a = float(input())
    area = a * a
    print(f'{area:.3f}')

elif fig_type == "rectangle":
    a = float(input())
    b = float(input())
    area = a * b
    print(f'{area:.3f}')
elif fig_type == "circle":
    a = float(input())
    area = math.pi * a * a
    print(f'{area:.3f}')
elif fig_type == "triangle":
    a = float(input())
    h = float(input())
    area = a * h / 2
    print(f'{area:.3f}')