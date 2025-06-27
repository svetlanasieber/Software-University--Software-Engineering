import sys


count_of_numbers = int(input())
max_number = - sys.maxsize
min_number = sys.maxsize

for numbers in range(count_of_numbers):
    current_number = int(input()) 
    if current_number > max_number:
        max_number = current_number
    if current_number < min_number:
        min_number = current_number
print(f"Max number: {max_number}")
print(f"Min number: {min_number}")
