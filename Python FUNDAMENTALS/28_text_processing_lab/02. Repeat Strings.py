final_string = ""

text_string = input().split()

for word in text_string:
    final_string += word * len(word)

print(final_string)