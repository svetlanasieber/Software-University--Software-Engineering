class Email:
    def __init__(self, sender, receiver, content):
        self.sender = sender
        self.receiver = receiver
        self.content = content
        self.is_sent = False

    def send(self):
        self.is_sent = True

    def get_info(self):
        return f"{self.sender} says to {self.receiver}: {self.content}. Sent: {self.is_sent}"


emails = []

command = input()
while not command == "Stop":
    information = command.split()
    sender = information[0]
    receiver = information[1]
    content = information[2]
    email = Email(sender, receiver, content)
    emails.append(email)
    command = input()

send_emails = [int(x) for x in input().split(", ")]

for x in send_emails:
    emails[x].send()

for email in emails:
    print(email.get_info())
