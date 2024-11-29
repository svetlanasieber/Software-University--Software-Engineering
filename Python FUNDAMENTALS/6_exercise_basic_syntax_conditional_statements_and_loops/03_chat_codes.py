# Create a program that receives the n number of messages sent.
# On the following n lines, it will receive integer
# numbers. For each number, the program should print a different message:

# • If the number is 88 - "Hello"
# • If the number is 86 - "How are you?"
#  If the number is not 88 or 86, and it is below 88 - "GREAT!"
# • If the number is over 88 - "Bye."

# number_of_messages = int(input())
# for current_message in range(number_of_messages):
#    number = int(input())
#    if number == 88:
#        print("Hello")
#    elif number == 86:
#        print("How are you?")
#    elif number < 88:
#        print("GREAT!")
#    else: # elif number > 88
#        print("Bye.")


number_of_messages = int(input())
for current_message in range(number_of_messages):
    number = int(input())
    if number == 88:
        print("Hello")
    elif number == 86:
        print("How are you?")
    elif number < 88:
        print("GREAT!")
    else:  # elif number > 88:
        print("Bye.")
