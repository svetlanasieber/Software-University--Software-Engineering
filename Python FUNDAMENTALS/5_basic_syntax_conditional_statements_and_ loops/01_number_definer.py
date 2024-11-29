num = float(input())

if num == 0:
    print("zero")
else:
    descriptor = ""

    if abs(num) < 1:
        descriptor = "small "
    elif abs(num) > 1_000_000:
        descriptor = "large "

    if num > 0:
        descriptor += "positive"
    else:
        descriptor += "negative"

    print(descriptor)
