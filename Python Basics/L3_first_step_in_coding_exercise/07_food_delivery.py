# Пилешко меню –  10.35 лв.
# Меню с риба – 12.40 лв.
# Вегетарианско меню  – 8.15 лв.

# •	Брой пилешки менюта – цяло число в интервала [0 … 99]
# •	Брой менюта с риба – цяло число в интервала [0 … 99]
# •	Брой вегетариански менюта – цяло число в интервала [0 … 99]

# Групата ще си поръча и десерт, чиято цена е равна на 20% от общата сметка (без доставката).
# Цената на доставка е 2.50 лв и се начислява най-накрая.
# Да се отпечата на конзолата един ред:  "{цена на поръчката}"

chicken_menu = int(input())
fish_menu = int(input())
veggie_menu = int(input())

chicken_menu_price = 10.35
fish_menu_price = 12.40
veggie_menu_price = 8.15

total_menu = chicken_menu_price * chicken_menu + fish_menu_price * fish_menu\
            + veggie_menu_price * veggie_menu

dessert_price = total_menu * 0.2

total_sum_menu = dessert_price + total_menu + 2.50


print(total_sum_menu)


