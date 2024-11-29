# number_n = int(input())

# for i in range (number_n):
#    current_string = input()
#    pure_string = True
#    for j in current_string:
#        if j == ',' or j == '_' or j == '.':
#            pure_string = False
#    if pure_string:
#        print(f'{current_string} is pure.')
#    else:
#        print(f'{current_string} is not pure!')



number_of_string = int(input())
for current_string in range(number_of_string):
    pure_or_not_pure_string = input()
    if (
        "," in pure_or_not_pure_string
        or "." in pure_or_not_pure_string
        or "_" in pure_or_not_pure_string
    ):
        print(f"{pure_or_not_pure_string} is not pure!")
    else:
        print(f"{pure_or_not_pure_string} is pure.")
