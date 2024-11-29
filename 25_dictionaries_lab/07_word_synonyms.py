count_of_words = int(input())

dictionary = {}

for _ in range(count_of_words):
    word = input()
    synonym = input()
    if word not in dictionary:
        dictionary[word] = []
    dictionary[word].append(synonym)

for word, list_of_synonyms in dictionary.items():
    print(f"{word} - {', '.join(list_of_synonyms)}")
