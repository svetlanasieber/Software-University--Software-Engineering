from math import log


def find_arbitrage(graph, start):
    # Initialize distances
    distances = {currency: float('-inf') for currency in graph}
    distances[start] = 0
    predecessors = {currency: None for currency in graph}

    # Bellman-Ford algorithm
    for _ in range(len(graph) - 1):
        for from_curr in graph:
            for to_curr, rate in graph[from_curr].items():
                if distances[from_curr] + rate > distances[to_curr]:
                    distances[to_curr] = distances[from_curr] + rate
                    predecessors[to_curr] = from_curr

    # Check for positive cycle (arbitrage opportunity)
    for from_curr in graph:
        for to_curr, rate in graph[from_curr].items():
            if distances[from_curr] + rate > distances[to_curr]:
                return True, reconstruct_cycle(predecessors, to_curr)

    return False, distances


def reconstruct_cycle(predecessors, start):
    path = []
    current = start
    visited = set()

    while current not in visited:
        visited.add(current)
        path.append(current)
        current = predecessors[current]
        if current is None:
            return [] 


    cycle_start = current
    cycle = [cycle_start]
    current = predecessors[cycle_start]
    while current != cycle_start:
        cycle.append(current)
        current = predecessors[current]
    cycle.append(cycle_start)  # Close the cycle
    return cycle[::-1]  



n = int(input())
graph = {}

for _ in range(n):
    from_curr, to_curr, price = input().split()
    price = log(float(price)) 

    if from_curr not in graph:
        graph[from_curr] = {}
    if to_curr not in graph:
        graph[to_curr] = {}

    graph[from_curr][to_curr] = price

target = input()


arbitrage_possible, result = find_arbitrage(graph, target)


if arbitrage_possible:
    print("True")
    print(" ".join(result))
else:
    print("False")
    for currency, log_price in result.items():
        price = round(2.718281828 ** log_price, 3) 
        print(f"{currency}: {price:.3f}")
