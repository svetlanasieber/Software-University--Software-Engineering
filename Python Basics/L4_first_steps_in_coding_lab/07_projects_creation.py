#	Името на архитекта - текст
#	Брой на проектите, които трябва да изготви - цяло число в интервала [0 … 100]
# Изготвянето на един проект отнема три часа

# "The architect {името на архитекта} will need {необходими часове} hours to complete {брой на проектите} project/s."

name_architect = input()
projects_numbers = int(input())
one_project = 3

needed_hours_for_projects = projects_numbers * one_project

print(f"The architect {name_architect} will need {needed_hours_for_projects} hours to complete {projects_numbers} project/s.")



