number_of_lines = int(input())
list_of_brackets = []
is_balanced = True

for _ in range(number_of_lines):
    string = input()
    if string == "(" or string == ")":
        list_of_brackets.append(string)

for index in range(len(list_of_brackets)):
    if index % 2 == 0 and not list_of_brackets[index] == "(":
        is_balanced = False
    elif not index % 2 == 0 and not list_of_brackets[index] == ")":
        is_balanced = False

if is_balanced:
    print("BALANCED")
else:
    print("UNBALANCED")
