price = input()
total_sum = 0

while not price == "special" and not price == "regular":
    price = float(price)
    if price < 0:
        print('Invalid price!')
    else:
        total_sum += price
    price = input()

taxes = total_sum * 0.20
discount = 1
if price == "special":
    discount = 0.90

if total_sum == 0:
    print('Invalid order!')
else:
    print('Congratulations you\'ve just bought a new computer!')
    print(f'Price without taxes: {total_sum :.2f}$')
    print(f'Taxes: {taxes :.2f}$')
    print('-----------')
    print(f'Total price: {discount * (total_sum + taxes) :.2f}$')