text = input()
dict = {}

for ch in text:
    if ch != " ":
        if ch not in dict:
            dict[ch] = 0
        dict[ch] += 1

[print(f"{key} -> {value}") for key, value in dict.items()]
