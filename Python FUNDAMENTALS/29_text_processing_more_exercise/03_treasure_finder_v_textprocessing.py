def decrypt_message(text):
    decrypted_text = ""
    idx = 0
    for symbol in text:
        decrypted_text += chr(ord(symbol) - key[idx])
        idx += 1
        if idx >= len(key):
            idx = 0
    return decrypted_text


key = [int(x) for x in input().split()]


def print_treasure_info(text):
    treasure_type = coordinates = None
    if "&" in text:
        treasure_type = text[text.find("&") + 1:text.rfind("&")]
    if "<" in text and ">" in text:
        coordinates = text[text.find("<") + 1:text.find(">")]
    if treasure_type and coordinates:
        print(f"Found {treasure_type} at {coordinates}")


while True:
    line = input()
    if line == "find":
        break

    message = decrypt_message(line)
    print_treasure_info(message)