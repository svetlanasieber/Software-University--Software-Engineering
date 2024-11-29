def merge(seq, start, end):
    start = 0 if start < 0 else start
    end = len(seq) - 1 if end > len(seq) - 1 else end
    merged_el = [el for el in seq if start <= seq.index(el) <= end]
    seq = [el for el in seq if el not in merged_el]
    seq.insert(start, "".join(merged_el))
    return seq


def divide(seq, ind, cnt):
    cnt = 1 if cnt < 1 else cnt
    cnt = len(seq[ind]) if cnt > len(seq[ind]) else cnt
    current_el = seq[ind]
    split_el = []
    reminder = len(current_el) % cnt
    substrings_length = len(current_el) // cnt
    while len(current_el) > substrings_length + reminder:
        split_el.append(current_el[:substrings_length])
        current_el = current_el[substrings_length:]
    split_el.append(current_el)
    seq.pop(ind)
    seq = seq[:ind] + split_el + seq[ind:]
    return seq


data = input().split()

command = input()
while not command == "3:1":
    tokens = command.split()
    command = tokens[0]

    if command == "merge":
        stat_index = int(tokens[1])
        end_index = int(tokens[2])
        data = merge(seq=data, start=stat_index, end=end_index)

    elif command == "divide":
        index = int(tokens[1])
        substrings_count = int(tokens[2])
        data = divide(seq=data, ind=index, cnt=substrings_count)

    command = input()

print(" ".join(data))
