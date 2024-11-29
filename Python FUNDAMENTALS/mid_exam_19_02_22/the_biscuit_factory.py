from math import floor
number_of_cookies_per_worker_per_day = int(input())
count_workers = int(input())
competitors_production_per_month = int(input())
cookies_per_day = floor(number_of_cookies_per_worker_per_day * count_workers)
count_cookies_per_month = 0

for day in range(1, 31):
    if day % 3 == 0:
        count_cookies_per_month += floor(cookies_per_day * 0.75)
    else:
        count_cookies_per_month += floor(number_of_cookies_per_worker_per_day * count_workers)

print(f'You have produced {count_cookies_per_month} biscuits for the past month.')
if count_cookies_per_month > competitors_production_per_month:
    diff = count_cookies_per_month - competitors_production_per_month
    percent_diff = diff / competitors_production_per_month * 100
    print(f'You produce {percent_diff:.2f} percent more biscuits.')
elif count_cookies_per_month < competitors_production_per_month:
    diff = competitors_production_per_month - count_cookies_per_month
    percent_diff = diff / competitors_production_per_month * 100
    print(f'You produce {percent_diff:.2f} percent less biscuits.')