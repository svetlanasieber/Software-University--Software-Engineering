number_one = int(input())
number_two = int(input())
operator = input()

if number_one == 0 == number_two:
    print(f"Cannot divide {number_one} by zero")
elif operator == "/":
    total = number_one / number_two
    print(f"{number_one} / {number_two} = {total:.2f}")
elif operator == "%":
    total = number_one % number_two
    print(f"{number_one} % {number_two} = {total}")
else:
    if operator == "+":
        total = number_one + number_two
    elif operator == "-":
        total = number_one - number_two
    elif operator == "*":
        total = number_one * number_two
    if total % 2 == 0:
        print(f"{number_one} {operator} {number_two} = {total} - even")
    else:
        print(f"{number_one} {operator} {number_two} = {total} - odd")
