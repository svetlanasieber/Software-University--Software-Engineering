#	Брой пакети химикали - цяло число в интервала [0...100]
#	Брой пакети маркери - цяло число в интервала [0...100]
#	Литри препарат за почистване на дъска - цяло число в интервала [0…50]
#	Процент намаление - цяло число в интервала [0...100]

#	Пакет химикали - 5.80 лв.
#	Пакет маркери - 7.20 лв.
#	Препарат - 1.20 лв (за литър)

# Напишете програма, която изчислява колко пари ще трябва да събере Ани, за да плати сметката

numbers_packages_pens = int(input())
numbers_packages_markers = int(input())
liters_detergent_for_cleaning = int(input())
discount_percent = int(input())

pack_pens = 5.80
pack_markers = 7.20
detergent_for_cleaning = 1.20

# Да се отпечата на конзолата колко пари ще са нужни на Ани, за да си плати сметката.

needed_sum = numbers_packages_pens * pack_pens + numbers_packages_markers * pack_markers + liters_detergent_for_cleaning * detergent_for_cleaning

# намаление за нея, което представлява някакъв процент от общата сума

needed_sum = needed_sum - needed_sum * (discount_percent / 100)

print(needed_sum)
