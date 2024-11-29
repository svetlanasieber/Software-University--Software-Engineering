# Вход от потребителя
city = input()
sales_volume = float(input())

# Проверка за валидност на обема на продажбите и града
if sales_volume < 0 or city not in ["Sofia", "Varna", "Plovdiv"]:
    print("error")
else:
    commission_rates = {
        "Sofia": [0.05, 0.07, 0.08, 0.12],
        "Varna": [0.045, 0.075, 0.1, 0.13],
        "Plovdiv": [0.055, 0.08, 0.12, 0.145]
    }

    if sales_volume <= 500:
        commission_rate = commission_rates[city][0]
    elif sales_volume <= 1000:
        commission_rate = commission_rates[city][1]
    elif sales_volume <= 10000:
        commission_rate = commission_rates[city][2]
    else:
        commission_rate = commission_rates[city][3]

    commission = sales_volume * commission_rate

    print("{:.2f}".format(commission))

# Решение от Лектор с вложени условни конструкции и логически оператори

city = input()
selling_volume = float(input())
comission = 0
flag = True

if city == 'Sofia':
    if 0 <= selling_volume <= 500:
        comission = selling_volume * 0.05
    elif 500 < selling_volume <= 1000:
        comission = selling_volume * 0.07
    elif 1000 < selling_volume <= 10000:
        comission = selling_volume * 0.08
    elif 10000 < selling_volume:
        comission = selling_volume * 0.12
    else:
        flag = False
elif city == 'Varna':
    if 0 <= selling_volume <= 500:
        comission = selling_volume * 0.045
    elif 500 < selling_volume <= 1000:
        comission = selling_volume * 0.075
    elif 1000 < selling_volume <= 10000:
        comission = selling_volume * 0.10
    elif 10000 < selling_volume:
        comission = selling_volume * 0.13
    else:
        flag = False
elif city == 'Plovdiv':
    if 0 <= selling_volume <= 500:
        comission = selling_volume * 0.055
    elif 500 < selling_volume <= 1000:
        comission = selling_volume * 0.08
    elif 1000 < selling_volume <= 10000:
        comission = selling_volume * 0.12
    elif 10000 < selling_volume:
        comission = selling_volume * 0.145
    else:
        flag = False
else:
    flag = False
if flag:
    print(f'{comission:.2f}')
else:
    print('error')