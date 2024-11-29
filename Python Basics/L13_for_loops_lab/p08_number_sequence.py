# Напишете програма, която чете n на брой цели числа.
# Принтирайте най-голямото и най-малкото число сред въведените.
import sys

# # Ние работим с цели числа. maxsize означава,максималната стойност, която един integer може да поеме!

count_of_numbers = int(input())
max_number = - sys.maxsize # -sys.maxsize za otricatelna stoinost -2, -1, 0
min_number = sys.maxsize

for numbers in range(count_of_numbers):
    current_number = int(input()) # vseki put si cheta edno novo chislo
    if current_number > max_number:
        max_number = current_number
    if current_number < min_number: #ne e elif, zaradi naj malkoto chislo
        min_number = current_number
print(f"Max number: {max_number}")
print(f"Min number: {min_number}")

# Drugiat variant bez maxsize:

#count_of_numbers = int(input())
#current_number = int(input())
#min_number = current_number
#max_number = current_number
#
#for numbers in range(count_of_numbers -1):
#    current_number = int(input()) # vseki put si cheta edno novo chislo
#    if current_number > max_number:
#        max_number = current_number
#    if current_number < min_number: #ne e elif, zaradi naj malkoto chislo
#        min_number = current_number
#print(f"Max number: {max_number}")
#print(f"Min number: {min_number}")