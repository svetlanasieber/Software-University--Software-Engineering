number_one = int(input())
number_two = int(input())
number_three = int(input())

if number_one >= number_two and number_one >= number_three:
    print(number_one)
elif number_two >= number_three and number_two >= number_one:
    print(number_two)
elif number_three >= number_one and number_three >= number_two:
    print(number_three)
# else:
#    print(number_three)
