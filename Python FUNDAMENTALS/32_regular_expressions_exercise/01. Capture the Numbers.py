import re

pattern = r'\d+'
result = ''

while True:
    line = input()
    if line:
        match = re.findall(pattern, line)
        if match:
            print(' '.join(match), end=" ")
    else:
        break