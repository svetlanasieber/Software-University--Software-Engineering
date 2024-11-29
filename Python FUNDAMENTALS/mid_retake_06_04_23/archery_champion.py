target_point = input().split('|')
int_target_pts = [int(x) for x in target_point]
point = 0
while True:
    command_line = input().split('@')
    command = command_line[0]
    if command == "Game over":
        break

    if command == "Shoot Left":
        strt_idx = int(command_line[1])
        lenght = int(command_line[2])
        shoot = strt_idx + lenght
        if strt_idx > len(target_point):
            continue
        elif shoot == len(target_point):
            shoot = len(target_point)
            int_target_pts[-shoot] -= 5
            point += 5
        else:
            int_target_pts[-shoot] -= 5


    elif command == "Shoot Right":
        strt_idx = int(command_line[1])
        lenght = int(command_line[2])
        shoot = strt_idx + lenght
        if strt_idx > len(target_point):
            continue
        elif strt_idx == len(target_point):
            shoot = len(target_point)
            int_target_pts[shoot] -= 5
            point += 5
        else:
            int_target_pts[shoot] -= 5