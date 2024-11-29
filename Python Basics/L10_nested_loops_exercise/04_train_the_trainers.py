jury_members_count = int(input())
string = input()
total_grades_sum = 0
presentations_count = 0

while (string != 'Finish'):
  presentation_name = string
  presentations_count += 1
  grades_sum = 0

  for i in range(jury_members_count):
    grade = float(input())
    grades_sum += grade

  avg_grade = grades_sum / jury_members_count

  total_grades_sum += avg_grade
  print(f'{presentation_name} - {avg_grade:.2f}.')
  string = input()

total_avg = total_grades_sum / presentations_count
print(f'Student\'s final assessment is {total_avg:.2f}.')