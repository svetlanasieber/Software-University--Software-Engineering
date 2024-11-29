def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

def generate_pins(first_upper, second_upper, third_upper):
    pins = []
    for i in range(1, first_upper + 1):
        if i % 2 == 0:
            for j in range(1, second_upper + 1):
                if is_prime(j):
                    for k in range(1, third_upper + 1):
                        if k % 2 == 0:
                            pins.append((i, j, k))
    return pins


first_upper = int(input())
second_upper = int(input())
third_upper = int(input())


valid_pins = generate_pins(first_upper, second_upper, third_upper)


for pin in valid_pins:
    print(*pin)
