square_meters = float(input())
first_price = square_meters * 7.61
discount = first_price * 0.18
total_price = first_price - discount

print(f"The final price is {total_price} lv.")
print(f"The discount is: {discount} lv.")