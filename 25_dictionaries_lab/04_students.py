info = input()
courses = dict()


while ":" in info:
    data = info.split(":")
    student = data[0]
    id = data[1]
    course = data[2]

    if course not in courses.keys():
        courses[course] = {}

    courses[course][id] = student

    info = input()

info = info.replace("_", " ")
for id in courses[info]:
    print(f"{courses[info][id]} - {id}")
