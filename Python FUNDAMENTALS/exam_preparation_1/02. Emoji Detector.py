import re

digit_pattern = r"\d"
emoji_pattern = r"(?P<surround>::|\*\*)(?P<emoji>[A-Z][a-z]{2,})\1"

text = input()

all_digits = [int(el.group()) for el in re.finditer(digit_pattern, text)]
cool_treshold = 1
for num in all_digits:
    cool_treshold *= num

print(f"Cool threshold: {cool_treshold}")

emoji_matches = [el.group() for el in re.finditer(emoji_pattern, text)]

print(f"{len(emoji_matches)} emojis found in the text. The cool ones are:")

for emoj in emoji_matches:
    emoji_coolness = 0
    for char in emoj[2:-2]:
        emoji_coolness += ord(char)
    if emoji_coolness >= cool_treshold:
        print(f"{emoj}")