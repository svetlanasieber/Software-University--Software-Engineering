companies = {}
command = input().split(" -> ")

while command[0] != "End":
    company = command[0]
    employee = command[1]
    if company not in companies:
        companies[company] = []
    if employee not in companies[company]:
        companies[company].append(employee)
    command = input().split(" -> ")

for company, employees in companies.items():
    print(company)
    for employee in employees:
        print(f"-- {employee}")
