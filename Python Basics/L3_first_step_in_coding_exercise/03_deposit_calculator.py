# 1.	Депозирана сума – реално число в интервала
# 2.	Срок на депозита (в месеци) – цяло число в интервала
# 3.	Годишен лихвен процент – реално число в интервала
# За да се намери процента се дели на 100

deposit = float(input())
months =  int(input())
annual_interest_percent = float(input())
# сума = депозирана сума  + срок на депозита * ((депозирана сума * годишен лихвен процент ) / 12)
# total_sum = deposit + months * ((deposit * annual_interest_percent / 100) / 12)

# Изчисляване на натрупана лихва
annual_interest = deposit * annual_interest_percent / 100

# Измисляване на лихвата за 1 месец
monthly_interest = annual_interest / 12

# Изчисляване на общата сума - депозита плюс месеците по месечната лихва
total_sum = deposit + (months * monthly_interest)

print(total_sum)







