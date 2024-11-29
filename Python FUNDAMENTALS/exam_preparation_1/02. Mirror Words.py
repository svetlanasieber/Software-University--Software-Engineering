import re

pattern = r"(\@|\#)([a-zA-Z]{3,}(\1){2}[a-zA-Z]{3,})(\1)"
regex = re.compile(pattern)

text = input()
matches = regex.findall(text)

mirror_words = []
for match in matches:
    word_one = match[1][:len(match[1]) // 2 - 1]
    word_two = match[1][len(match[1]) // 2 + 1:]
    if word_one == word_two[::-1]:
        mirror_words.append(f"{word_one} <=> {word_two}")

if not matches:
    print("No word pairs found!")
else:
    print(f"{len(matches)} word pairs found!")
if not mirror_words:
    print("No mirror words!")
else:
    print(f"The mirror words are:\n{', '.join(mirror_words)}")