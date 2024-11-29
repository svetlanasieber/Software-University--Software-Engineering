import re

text = input()

title_pattern = r"<title>(?P<title>.*?)<\/title>"
content_pattern = r"<body>(?P<content>.*?)</body>"
filter_pattern = r"<[^<]+?>|\\n"

title = re.search(title_pattern, text).group("title")
raw_content = re.search(content_pattern, text).group("content")
plain_content = re.sub(filter_pattern, '', raw_content)

print(f"Title: {title}\nContent: {plain_content}")