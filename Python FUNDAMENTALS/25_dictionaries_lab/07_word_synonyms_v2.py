number = int(input())
synonyms = {}

for num in range(number):
    word = input()
    synonym = input()
    if word not in synonyms.keys():
        synonyms[word] = list()

    synonyms[word].append(synonym)

for word in synonyms:
    print(f"{word} - {', '.join(synonyms[word])}")
