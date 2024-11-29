list_of_happiness = [int(x) for x in input().split()]
happiness_improvement_factor = int(input())

improved_list_of_happiness = [
    el * happiness_improvement_factor for el in list_of_happiness
]

average_happiness = sum(improved_list_of_happiness) / len(improved_list_of_happiness)

greater_happiness = [
    employee for employee in improved_list_of_happiness if employee >= average_happiness
]
if len(greater_happiness) >= len(improved_list_of_happiness) / 2:
    print(
        f"Score: {len(greater_happiness)}/{len(improved_list_of_happiness)}. Employees are happy!"
    )
else:
    print(
        f"Score: {len(greater_happiness)}/{len(improved_list_of_happiness)}. Employees are not happy!"
    )
