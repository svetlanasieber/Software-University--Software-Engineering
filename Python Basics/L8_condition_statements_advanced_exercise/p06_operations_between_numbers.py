# Малък калкулатор

# •	N1 - цяло число;
# •	N2 - цяло число;
# •	Оператор - един символ измежду: "+", "-", "*", "/", "%".

# •	Ако операцията е събиране, изваждане или умножение:
# o	 "{N1} {оператор} {N2} = {резултат} - {even/odd}"

# •	Ако операцията е деление:
# o	"{N1} / {N2} = {резултат}" - резултат, форматиран до втория знак след десетичната запетая

# •	Ако операцията е модулно деление:
# o	"{N1} % {N2} = {остатък}"

# •	В случай на деление с 0 (нула):
# o	"Cannot divide {N1} by zero"

first_num = int(input())
second_num = int(input())
operator = input()

result = 0
zero_flag = False
if operator == "+":
    result = first_num + second_num
elif operator == "-":
    result = first_num - second_num
elif operator == "*":
    result = first_num * second_num
elif operator == "/":
    if second_num == 0:
        zero_flag = True
    else:
        result = first_num / second_num
elif operator == "%":
    if second_num == 0:
        zero_flag = True
    else:
        result = first_num % second_num


if operator == "+" or operator == "-" or operator == "*":
    if result % 2 == 0:
        print(f"{first_num} {operator} {second_num} = {result} - even")
    else:
        print(f"{first_num} {operator} {second_num} = {result} - odd")
elif operator == "/":
    if zero_flag: # zero_flag == True
        print(f"Cannot divide {first_num} by zero")
    else:
        print(f"{first_num} {operator} {second_num} = {result:.2f}")
elif operator == "%":
    if zero_flag: # zero_flag == True
        print(f"Cannot divide {first_num} by zero")
    else:
        print(f"{first_num} {operator} {second_num} = {result}")












