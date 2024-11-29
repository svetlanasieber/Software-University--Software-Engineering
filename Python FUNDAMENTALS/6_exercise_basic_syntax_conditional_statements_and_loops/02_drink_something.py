# A kid is defined as someone under or at the age of 14.
# A teen is defined as someone under or at the age of 18.
# A young adult is defined as someone under or at the age of 21.
# An adult is defined as someone above the age of 21.

# Kids drink toddy,
# teens drink coke,
# young adults drink beer,
# and adults drink whisky.
# => Create a program that
# receives a person's age and prints what he/she drinks.

ages = int(input())
drink = ""
if ages <= 14:
    drink = "toddy"
elif ages <= 18:
    drink = "coke"
elif ages <= 21:
    drink = "beer"
else:  # ages > 21
    drink = "whisky"
print(f"drink {drink}")
