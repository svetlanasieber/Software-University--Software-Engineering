# една опаковка храна за кучета е на цена 2.50 лв
# опаковка храна за котки струва 4 лв

#	Броят на опаковките храна за кучета – цяло число в интервала [0… 100]
#	Броят на опаковките храна за котки –  цяло число в интервала [0… 100]

# "{крайната сума} lv."

numbers_package_dog_food = int(input())
numbers_package_cat_food = int(input())

price_dog_food = 2.50
price_cat_food = 4

total_sum = price_dog_food * numbers_package_dog_food + price_cat_food * numbers_package_cat_food


# print(str(total_amount) + " lv.") => Конкатенация
print(str(total_sum) + " lv.")








