from math import floor

record_in_sec = float(input())
distance_in_m = float(input())
time_in_sec_per_m = float(input())

time_for_distance = distance_in_m * time_in_sec_per_m
slowing_down = floor(distance_in_m / 15) * 12.5

total_time = time_for_distance + slowing_down

if total_time < record_in_sec:
    print(f'Yes, he succeeded! The new world record is {total_time:.2f} seconds.')

else:
    print(f'No, he failed! He was {total_time - record_in_sec:.2f} seconds slower.')
