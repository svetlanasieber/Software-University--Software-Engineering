import re
text = input()
pattern = r"(?:[@{1,}|#{1,}])(?P<color>[a-z]{3,})(?:[@{1,}|#{1,}]([^A-Za-z0-9]*)?)(?:\/{1,})(?P<amount>[0-9]*)(?:\/{" \
          r"1,})"

matches = re.finditer(pattern, text)
for match in matches:
    print(f"You found {match.group('amount')} {match.group('color')} eggs!")