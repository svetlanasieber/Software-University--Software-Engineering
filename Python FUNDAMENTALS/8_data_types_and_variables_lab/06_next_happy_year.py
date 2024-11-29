current_year = int(input())

next_year = current_year + 1
while True:
    next_year_as_list = list(str(next_year))
    if len(set(next_year_as_list)) == len(next_year_as_list):
        print(next_year)
        break

    next_year += 1

# 2.
# year = int(input())
#
# is_happy_year = False
#
# while not is_happy_year:
#     year += 1
#     str_year = str(year)
#     set_year = set()
#
#     for i in range(len(str_year)):
#         set_year.add(str_year[i])
#
#     is_happy_year = len(str_year) == len(set_year)
#
# print(year)


# 3.
# current_year = int(input())
#
# next_year = current_year + 1
# while True:
#     next_year_as_list = list(str(next_year))
#     if len(set(next_year_as_list)) == len(next_year_as_list):
#         print(next_year)
#         break
#
#     next_year += 1

# 4.
# year = int(input())
# happy_year = False
#
# while not happy_year:
#     year += 1
#     set_year = set()
#
#     for years in range(len(str(year))):
#         set_year.add(str(year)[years])
#
#         happy_year = len(set_year) == len(str(year))
#
# print(year)

# 5.

# year = int(input())
# year_is_special = False
# while not year_is_special:
#     year += 1
#     year_as_string = str(year)
#     year_is_special = True
#     for digit in year_as_string:
#         if year_as_string.count(digit) > 1:
#             year_is_special = False
#             break
# print(year)
