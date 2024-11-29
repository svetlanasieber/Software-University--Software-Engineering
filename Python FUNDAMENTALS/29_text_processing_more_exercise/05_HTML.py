title = input()
article = input()
output = [f"<h1>\n\t{title}\n</h1>", f"<article>\n\t{article}\n</article>"]

while True:
    comment = input()
    if comment == "end of comments":
        break
    output.append(f"<div>\n\t{comment}\n</div>")

print("\n".join(output))