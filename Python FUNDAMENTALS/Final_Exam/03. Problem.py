book = {}
line = input().split(" | ")
for each in line:
    name, definiciton = each.split(": ")
    if name not in book:
        book[name] = []
    book[name].append(definiciton)

test_on = input().split(" | ")
task = input()
if task == "Test":
    for w in test_on:
        if w in book.keys():
            print(f"{w}:")
            for v in book[w]:
                print(f" -{v}")
elif task == "Hand Over":
    print(" ".join([k for k in book.keys()]))