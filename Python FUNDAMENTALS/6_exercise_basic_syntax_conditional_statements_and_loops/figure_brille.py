number = int(input())

if 3 <= number <= 100:
    print((2 * (number)) * "*" + (number) * " " + (2 * (number)) * "*")
    for mid in range(number - 2):
        print("*", end="")
        print((2 * (number) - 2) * "/", end="")
        print("*", end="")
        if mid == int((number - 1) / 2 - 1):
            print((number) * "|", end="")
        else:
            print((number) * " ", end="")
        print("*", end="")
        print((2 * (number) - 2) * "/", end="")
        print("*", end="")
        print()
    print(2 * (number) * "*" + (number) * " " + (2 * (number)) * "*")
