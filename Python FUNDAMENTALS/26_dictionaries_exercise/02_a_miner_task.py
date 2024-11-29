resource = input()
dict = {}


def validate_key_existing(dictionary, key, default_value=0):
    if key not in dictionary:
        dictionary[key] = default_value


while resource != "stop":
    qty = int(input())
    validate_key_existing(dict, resource)
    dict[resource] += qty
    resource = input()

[print(f"{key} -> {value}") for key, value in dict.items()]
