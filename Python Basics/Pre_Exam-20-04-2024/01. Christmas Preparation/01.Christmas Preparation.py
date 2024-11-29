rolls_wrapping_paper = int(input())
fabric_rolls = int(input())
liters_of_glue = float(input())
percentage_discount = int(input())

wrapping_paper_1 = 5.80
fabric_2 = 7.20
glue_3 = 1.20

price_wrapping = wrapping_paper_1 * rolls_wrapping_paper
price_fabric = fabric_2 * fabric_rolls
price_glue = glue_3 * liters_of_glue

total_sum = price_wrapping + price_fabric + price_glue

discount = total_sum * percentage_discount / 100

total_sum -= discount

print(f'{total_sum:.3f}')