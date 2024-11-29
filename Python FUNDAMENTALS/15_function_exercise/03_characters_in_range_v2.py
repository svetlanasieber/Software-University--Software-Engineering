def char_in_range(start, end):
    result = []
    for char in range(ord(start) + 1, ord(end)):
        result.append(chr(char))
    return result


ch_1 = input()
ch_2 = input()
res = " ".join(char_in_range(ch_1, ch_2))
print(res)
