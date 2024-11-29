class Party:
    def __init__(self):
        self.people = []


name = input()
my_party = Party()
while not name == "End":
    my_party.people.append(name)
    name = input()

total_people_going = len(my_party.people)
print(f"Going: {', '.join(my_party.people)}")
print(f"Total: {total_people_going}")
