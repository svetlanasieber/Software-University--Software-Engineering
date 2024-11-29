followers = {}
while True:
    command = input()
    if command == "Log out":
        break
    command = command.split(': ')
    if command[0] == "New follower":
        username = command[1]
        if username not in followers:
            followers[username] = []
            followers[username].append(0)
            followers[username].append(0)
    elif command[0] == "Like":
        username, count_likes = command[1], int(command[2])
        if username not in followers:
            followers[username] = []
            followers[username].append(count_likes)
            followers[username].append(0)
        else:
            followers[username][0] += count_likes
    elif command[0] == "Comment":
        username = command[1]
        if username not in followers:
            followers[username] = []
            followers[username].append(0)
            followers[username].append(1)
        else:
            followers[username][1] += 1

    elif command[0] == "Blocked":
        username = command[1]
        if username not in followers:
            print(f"{username} doesn't exist.")
        else:
            del followers[username]


print(f"{len(followers)} followers")
for name in followers:
    total = followers[name][0] + followers[name][1]
    print(f"{name}: {total}")