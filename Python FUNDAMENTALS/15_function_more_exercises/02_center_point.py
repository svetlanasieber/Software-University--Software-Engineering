def calculate_distance_from_center(
    x1_coordinate, y1_coordinate, x2_coordinate, y2_coordinate
):
    from math import floor

    distance_from_center_point_1 = abs(x1_coordinate) + abs(y1_coordinate)
    distance_from_center_point_2 = abs(x2_coordinate) + abs(y2_coordinate)
    if distance_from_center_point_1 <= distance_from_center_point_2:
        print(f"({floor(x1_coordinate)}, {floor(y1_coordinate)})")
    else:
        print(f"({floor(x2_coordinate)}, {floor(y2_coordinate)})")


x_coordinate_point_1 = float(input())
y_coordinate_point_1 = float(input())
x_coordinate_point_2 = float(input())
y_coordinate_point_2 = float(input())

calculate_distance_from_center(
    x_coordinate_point_1,
    y_coordinate_point_1,
    x_coordinate_point_2,
    y_coordinate_point_2,
)
