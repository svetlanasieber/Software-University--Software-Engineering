# Прочетете броя на снежните топки N.
# Завъртете цикъла N пъти, за да прочетете данните за всяка снежна топка.
# За всяка снежна топка изчислете нейната стойност по формулата
# (snowball_weight / snowball_time) ** snowball_quality.
# Проследете снежната топка с най-висока стойност и нейните данни.
# Отпечатайте данните за снежната топка с най-висока стойност.


def compute_best_snowball():
    # Read the number of snowballs
    N = int(input())

    # Initialize the maximum value and its details
    max_value = -1
    best_weight = 0
    best_time = 0
    best_quality = 0

    # Loop to read details and calculate snowball values
    for _ in range(N):
        weight = int(input())
        time = int(input())
        quality = int(input())

        # Calculate the current snowball's value
        value = (weight / time) ** quality

        # Check if the current snowball's value is the highest so far
        if value > max_value:
            max_value = value
            best_weight = weight
            best_time = time
            best_quality = quality

    # Print the best snowball details
    print(f"{best_weight} : {best_time} = {int(max_value)} ({best_quality})")


# Execute the function
compute_best_snowball()
