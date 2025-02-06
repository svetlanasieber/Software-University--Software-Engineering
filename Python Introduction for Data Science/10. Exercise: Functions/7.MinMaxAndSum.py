def min_number(numbers):
    minimum_number = min(numbers)
    return f"The minimum number is {minimum_number}"


def max_number(numbers):
    maximum_number = max(numbers)
    return f"The maximum number is {maximum_number}"


def sum_numbers(numbers):
    sum_number = sum(numbers)
    return f"The sum number is: {sum_number}"


all_numbers = list(map(int, input().split(" ")))
print(min_number(all_numbers))
print(max_number(all_numbers))
print(sum_numbers(all_numbers))