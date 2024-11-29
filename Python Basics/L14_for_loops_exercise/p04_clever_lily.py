# •	Възрастта на Лили - цяло число в интервала [1...77]
# •	Цената на пералнята - число в интервала [1.00...10 000.00]
# •	Единична цена на играчка - цяло число в интервала [0...40]

# вече е на N години. За всеки свой рожден ден тя получава подарък.
# •	За нечетните рождени дни (1, 3, 5...n) получава играчки.
# •	За четните рождени дни (2, 4, 6...n) получава пари.

# За втория рожден ден получава 10.00 лв, като сумата се увеличава с 10.00 лв.,
# за всеки следващ четен рожден ден (2 -> 10, 4 -> 20, 6 -> 30...и т.н.).
# През годините Лили тайно е спестявала парите. Братът на Лили,
# в годините, които тя получава пари, взима по 1.00 лев от тях.
# Лили продала играчките получени през годините,
# всяка за P лева и добавила сумата към спестените пари. С парите искала да си купи пералня за X лева.
# Напишете програма, която да пресмята, колко пари е събрала и дали ѝ стигат да си купи пералня

# Програмата изчислява сумата, която Лили е спестила до сегашната си възраст,
# като отчита парите, които брат ѝ взема, и парите, които тя печели от продажбата на играчки.
# След това проверява дали тя има достатъчно,
# за да купи пералната машина, като отпечатва съответното съобщение и оставащата или необходимата сума.

# Read input
age = int(input())
washing_machine_price = float(input())
toy_price = int(input())

# Initialize variables
total_money = 0
money_gift = 10  # Starting money gift for even years
toys_count = 0

# Loop through each year up to the current age
for i in range(1, age + 1):
    if i % 2 == 0:  # Even year, she receives money
        total_money += money_gift  # Add money gift to total
        money_gift += 10  # Increase the money gift for the next even year
        total_money -= 1  # Brother takes 1 unit of money
    else:  # Odd year, she receives a toy
        toys_count += 1

# Add money from selling toys
total_money += toys_count * toy_price

# Check if she can buy the washing machine
if total_money >= washing_machine_price:
    print(f"Yes! {total_money - washing_machine_price:.2f}")
else:
    print(f"No! {washing_machine_price - total_money:.2f}")
