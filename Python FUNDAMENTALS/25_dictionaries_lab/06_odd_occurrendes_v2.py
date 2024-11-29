seq_of_words = input().lower().split()

words_dict = {}

for word in seq_of_words:
    if word not in words_dict:
        words_dict[word] = 0
    words_dict[word] += 1

for word, count in words_dict.items():
    if not count % 2 == 0:
        print(word, end=" ")
