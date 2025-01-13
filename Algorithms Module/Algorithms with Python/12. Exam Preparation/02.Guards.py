def dfs(graph, start, visited):
    visited[start] = True
    for neighbor in graph[start]:
        if not visited[neighbor]:
            dfs(graph, neighbor, visited)


n = int(input())
m = int(input())


graph = {i: [] for i in range(1, n+1)}


for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)


start = int(input())


visited = {i: False for i in range(1, n+1)}
dfs(graph, start, visited)


unreachable = [node for node in range(1, n+1) if not visited[node]]


print(*sorted(unreachable))
