# SLICING [start:end:step]

# first_string = input()
# second_string = input()
# last_string = first_string
# for symbol in range(len(second_string)):
#    left_string = second_string[:symbol + 1]
#    right_string = first_string[symbol + 1:]
#    curr_word = left_string + right_string
#    if curr_word == last_string:
#        continue
#    print(curr_word)
#    last_string = curr_word




first_string = input()
second_string = input()
last_printed_string = first_string
for character_index in range(len(first_string)):
    left_part = second_string[: character_index + 1]
    right_part = first_string[character_index + 1 :]
    new_string = left_part + right_part
    if new_string != last_printed_string:
        print(new_string)
        last_printed_string = new_string
