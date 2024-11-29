#YEAR = 365.2422
#centuries = int(input())
#years = centuries * 100
#days = int(years * YEAR)
#hours = days * 24
#minutes = hours * 60
#
#print(f"{centuries} centuries = {years} years = {days} days = {hours} hours = {minutes} minutes")


# 2.

centuries = int(input())
years = centuries * 100
days = int(years * 365.2422)
hours = days * 24
minutes = hours * 60
print(f"{centuries} centuries = {years} "
      f"years = {days} days = {hours} "
      f"hours = {minutes} minutes")
