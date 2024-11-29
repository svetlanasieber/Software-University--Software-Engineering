car_info = input().split(">>")
car_details = []

for i in range(len(car_info)):
    car_details.append(car_info[i].split())
total = 0
for i in range(len(car_details)):
    current_tax = 0
    if car_details[i][0] == 'family':
        current_tax = 50 - 5 * int(car_details[i][1])
        current_tax += 12 * (int(car_details[i][2]) // 3000)
        print(f'A {car_details[i][0]} car will pay {current_tax:.2f} euros in taxes.')
    elif car_details[i][0] == 'heavyDuty':
        current_tax = 80 - 8 * int(car_details[i][1])
        current_tax += 14 * (int(car_details[i][2]) // 9000)
        print(f'A {car_details[i][0]} car will pay {current_tax:.2f} euros in taxes.')
    elif car_details[i][0] == 'sports':
        current_tax = 100 - 9 * int(car_details[i][1])
        current_tax += 18 * (int(car_details[i][2]) // 2000)
        print(f'A {car_details[i][0]} car will pay {current_tax:.2f} euros in taxes.')
    else:
        print('Invalid car type.')
    total += current_tax

print(f'The National Revenue Agency will collect {total:.2f} euros in taxes.')