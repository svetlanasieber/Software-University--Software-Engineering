movie_name = input()

students_tickets = 0
standard_tickets = 0
kids_tickets = 0
total_tickets = 0
while movie_name != "Finish":
    tickets_number = int(input())
    ticket_type = input()
    total = 0
    while True:
        if ticket_type == "standard":
            standard_tickets += 1
        elif ticket_type == "kid":
            kids_tickets += 1
        elif ticket_type == "student":
            students_tickets += 1
        if ticket_type == "Finish" or total == tickets_number:
            print(f"{movie_name} - {((total / tickets_number) * 100):.2f}% full.")
            movie_name = ticket_type
            break
        elif ticket_type == "End":
            print(f"{movie_name} - {((total / tickets_number) * 100):.2f}% full.")
            movie_name = input()
            break

        total += 1
        total_tickets += 1
        ticket_type = input()

print(f"Total tickets: {total_tickets}")
print(f"{((students_tickets / total_tickets) * 100):.2f}% student tickets.")
print(f"{((standard_tickets / total_tickets) * 100):.2f}% standard tickets.")
print(f"{((kids_tickets / total_tickets) * 100):.2f}% kids tickets.")
