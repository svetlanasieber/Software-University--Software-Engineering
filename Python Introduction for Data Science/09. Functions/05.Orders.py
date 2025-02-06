def total_price_of_order(order_type, order_quantity):
    total_price = None
    if order_type == "coffee":
        total_price = order_quantity * 1.50
    elif order_type == "coke":
        total_price = order_quantity * 1.40
    elif order_type == "water":
        total_price = order_quantity * 1.00
    elif order_type == "snacks":
        total_price = order_quantity * 2.00
    return total_price


product = input()
quantity = int(input())
print(f"{total_price_of_order(product, quantity):.2f}")