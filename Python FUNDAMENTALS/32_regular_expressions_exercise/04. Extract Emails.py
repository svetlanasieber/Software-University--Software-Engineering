import re

text = input()

pattern = r"(?<!\S)(?P<user>(([a-zA-Z0-9]+[\.\-\_]?[a-zA-Z0-9]+)))" \
          r"@(?P<host>(([a-z]+[-]?[a-z]+)(\.[a-z]+[-]?[a-z]+)+))\b"
regex_pattern = re.compile(pattern)
matches = re.finditer(regex_pattern, text)

for mail in matches:
    print(mail.group())