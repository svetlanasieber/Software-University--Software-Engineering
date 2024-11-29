employee_happiness = list(map(int, input().split(" ")))
factor = int(input())

happy_employee = list(
    filter(
        lambda x: x >= sum(employee_happiness) / len(employee_happiness),
        employee_happiness,
    )
)

if len(happy_employee) >= len(employee_happiness) / 2:
    print(
        f"Score: {len(happy_employee)}/{len(employee_happiness)}. Employees are happy!"
    )

else:
    print(
        f"Score: {len(happy_employee)}/{len(employee_happiness)}. Employees are not happy!"
    )
