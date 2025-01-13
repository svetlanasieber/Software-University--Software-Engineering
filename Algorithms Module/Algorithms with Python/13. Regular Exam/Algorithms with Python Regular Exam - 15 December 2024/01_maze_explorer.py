from collections import deque



def shortest_path_in_maze(n, maze):

    start = None
    end = None
    for i in range(n):
        for j in range(n):
            if maze[i][j] == 'S':
                start = (i, j)
            elif maze[i][j] == 'E':
                end = (i, j)


    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]


    queue = deque([(start[0], start[1], 0)])
    visited = [[False] * n for _ in range(n)]
    visited[start[0]][start[1]] = True


    while queue:
        x, y, steps = queue.popleft()


        if (x, y) == end:
            return steps


        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and maze[nx][ny] != '#':
                visited[nx][ny] = True
                queue.append((nx, ny, steps + 1))
    return -1



if __name__ == "__main__":
    n = int(input())
    maze = []
    print()
    for _ in range(n):
        maze.append(list(input().strip()))

    result = shortest_path_in_maze(n, maze)
    print(result)
