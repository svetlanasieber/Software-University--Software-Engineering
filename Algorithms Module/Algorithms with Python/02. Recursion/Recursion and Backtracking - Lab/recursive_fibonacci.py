def get_fibonacci(n):
    first_element = 0
    last_element = 1
    result = 0
    for i in range(n):
        result = first_element + last_element
        first_element, last_element = last_element, result
    return result


number = int(input())
print(get_fibonacci(number))
