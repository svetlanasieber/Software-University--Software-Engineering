def calculate_party_profit(group_size, days):
    total_coins = 0

    for day in range(1, days + 1):
        # Check for the 10th and 15th day companions update
        if day % 10 == 0:
            group_size -= 2
        if day % 15 == 0:
            group_size += 5

        # Calculate the daily earnings and expenses
        total_coins += 50
        total_coins -= group_size * 2  # Food cost

        if day % 3 == 0:  # Motivational party
            total_coins -= group_size * 3  # Water cost

        if day % 5 == 0:  # Slaying a boss monster
            total_coins += group_size * 20
            if day % 3 == 0:  # If there's also a motivational party
                total_coins -= group_size * 2  # Additional cost

    coins_per_companion = total_coins // group_size
    return f"{group_size} companions received {coins_per_companion} coins each."


# Take user input and display the result
group_size = int(input())
days = int(input())

print(calculate_party_profit(group_size, days))
