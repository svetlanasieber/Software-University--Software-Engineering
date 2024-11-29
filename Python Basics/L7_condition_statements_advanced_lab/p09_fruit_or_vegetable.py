# Програмата създава речник, който съдържа съответствията между продуктите и техния вид (плод или зеленчук).
# След това програмата приема вход от потребителя и проверява дали въведеният продукт се съдържа в речника.
# Ако продуктът е намерен в речника, програмата извежда съответния вид (плод или зеленчук), в противен случай извежда "unknown".

# Създаване на речник със съответствия между продукти и техния вид
product_to_type = {
    "banana": "fruit",
    "apple": "fruit",
    "kiwi": "fruit",
    "cherry": "fruit",
    "lemon": "fruit",
    "grapes": "fruit",
    "tomato": "vegetable",
    "cucumber": "vegetable",
    "pepper": "vegetable",
    "carrot": "vegetable"
}

# Вход от потребителя
product = input()


# Проверка за вида на продукта
if product in product_to_type:
    product_type = product_to_type[product]
    print(product_type)
else:
    print("unknown")
