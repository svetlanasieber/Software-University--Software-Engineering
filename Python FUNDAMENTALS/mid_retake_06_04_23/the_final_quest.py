all_words = input().split()



while True:
    command_line = input().split()
    command = command_line[0]
    if command == "Stop":
        break

    if command == "Delete":
        word_index = int(command_line[1]) + 1
        if word_index < len(all_words):
            all_words.pop(word_index)
        else:
            continue
    elif command == "Swap":
        old_word = command_line[1]
        new_word = command_line[2]
        if old_word in all_words and new_word in all_words:
            idx_1 = all_words.index(old_word)
            idx_2 = all_words.index(new_word)
            all_words[idx_1], all_words[idx_2] = all_words[idx_2], all_words[idx_1]
        else:
            continue
    elif command == "Put":
        new_word = command_line[1]
        index = int(command_line[2]) - 1
        if index < 0:
            continue
        elif index < len(all_words):
            all_words.insert(index, new_word)
        elif index == len(all_words):
            all_words.append(new_word)
        else:
            continue
    elif command == "Sort":
        all_words.sort(reverse=True)
    elif command == "Replace":
        word = command_line[1]
        sarching_word = command_line[2]
        if sarching_word in all_words:
            word_idx = all_words.index(sarching_word)
            all_words[word_idx] = word

print(' '.join(all_words))