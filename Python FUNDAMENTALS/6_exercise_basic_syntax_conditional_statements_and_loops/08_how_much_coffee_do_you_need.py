# command = input()
# coffee_counter = 0

# print(name.lower())
# print(name.upper())


# while command != "END":

#    if command == "coding" or command == "dog" or command == "cat" or command == "movie":
#        coffee_counter += 1
#    elif command == "CODING" or command == "DOG" or command == "CAT" or command == "MOVIE":
#        coffee_counter += 2
#    command = input()

# if coffee_counter > 5:
#    print("You need extra sleep")
# else:
#    print(coffee_counter)





coffee_counter = 0
command = input()
while command != "END":
    if (
        command.lower() == "coding"
        or command.lower() == "dog"
        or command.lower() == "cat"
        or command.lower() == "movie"
    ):
        if command.islower():
            coffee_counter += 1
        else:  # if command.isupper()
            coffee_counter += 2
    command = input()
if coffee_counter > 5:
    print("You need extra sleep")
else:
    print(coffee_counter)
