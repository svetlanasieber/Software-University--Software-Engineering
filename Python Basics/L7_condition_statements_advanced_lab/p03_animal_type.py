# 1.	dog -> mammal
# 2.	crocodile, tortoise, snake -> reptile
# 3.	others -> unknown

type_of_animal = input()

if type_of_animal == "dog":
    print("mammal")
elif type_of_animal == "crocodile":
    print("reptile")
elif type_of_animal == "tortoise":
    print("reptile")
elif type_of_animal == "snake":
    print("reptile")
else:
    print("unknown")


