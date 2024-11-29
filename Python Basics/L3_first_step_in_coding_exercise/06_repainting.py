#	Необходимо количество найлон (в кв.м.) - цяло число в интервала [1... 100]
#	Необходимо количество боя (в литри) - цяло число в интервала [1…100]
#	Количество разредител (в литри) - цяло число в интервала [1…30]
#	Часовете, за които майсторите ще свършат работата - цяло число в интервала [1…9]

# Предпазен найлон - 1.50 лв. за кв. метър
# Боя - 14.50 лв. за литър
# Разредител за боя - 5.00 лв. за литър

# Да се отпечата на конзолата един ред:
# •	"{сумата на всички разходи}"
# * Румен иска да добави още 10% от количеството боя и 2 кв.м. найлон, разбира се и 0.40 лв. за торбички.
# * Сумата, която се заплаща на майсторите за 1 час работа, е равна на 30% от сбора на всички разходи за материали.

quantity_nylon = int(input())
quantity_paint = int(input())
quantity_thinner = int(input())
workers_hours = int(input())

nylon_price = 1.50
paint_price = 14.50
thinner_price = 5
bags_price = 0.40

materials_price = nylon_price * (quantity_nylon + 2)\
            + paint_price * quantity_paint * 1.1\
            + thinner_price * quantity_thinner\
            + bags_price


total_payment_workers = materials_price * 0.3 * workers_hours # 30 / 100
total_sum = materials_price + total_payment_workers



print(total_sum)


