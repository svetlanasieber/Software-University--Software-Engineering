import heapq

def dijkstra(start, end, graph):

    pq = [(0, start, [])]
    visited = set()

    while pq:
        dist, city, path = heapq.heappop(pq)

        if city in visited:
            continue
        visited.add(city)


        path = path + [city]


        if city == end:
            return path, dist


        for neighbor, weight in graph.get(city, []):
            if neighbor not in visited:
                heapq.heappush(pq, (dist + weight, neighbor, path))

    return None, float('inf')


def build_graph(roads, closed_roads):
    graph = {}
    closed_set = set(closed_roads)

    for city1, city2, distance in roads:
        if (city1, city2) not in closed_set and (city2, city1) not in closed_set:
            graph.setdefault(city1, []).append((city2, distance))
            graph.setdefault(city2, []).append((city1, distance))
    return graph


if __name__ == "__main__":

    r = int(input())
    roads = []
    for _ in range(r):
        city1, city2, dist = input().split(" - ")
        roads.append((city1, city2, int(dist)))

    closed_input = input()
    closed_roads = [tuple(road.split("-")) for road in closed_input.split(",")]

    start_city = input()
    end_city = input()


    graph = build_graph(roads, closed_roads)


    path, distance = dijkstra(start_city, end_city, graph)


    print(" - ".join(path))
    print(distance)
