number_snowballs = int(input())

best_snowball_quality = 0
best_snowball_date = ""

for i in range(1, number_snowballs + 1):
    weight_of_the_snowball = int(input())
    time_needed = int(input())
    quality_snowball = int(input())

    snowball_calculation = (weight_of_the_snowball / time_needed) ** quality_snowball

    if snowball_calculation > best_snowball_quality:
        best_snowball_quality = snowball_calculation
        best_snowball_date = (
            f"{weight_of_the_snowball} : {time_needed} = {snowball_calculation:.0f}"
            f" ({quality_snowball})"
        )

print(best_snowball_date)
