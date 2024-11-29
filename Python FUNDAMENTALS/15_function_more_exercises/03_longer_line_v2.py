def calculate_distance_from_center(
    x1_coordinate_line1,
    y1_coordinate_line1,
    x2_coordinate_line1,
    y2_coordinate_line1,
    x1_coordinate_line2,
    y1_coordinate_line2,
    x2_coordinate_line2,
    y2_coordinate_line2,
):
    from math import floor

    distance_from_center_point_1 = abs(x1_coordinate_line1) + abs(y1_coordinate_line1)
    distance_from_center_point_2 = abs(x2_coordinate_line1) + abs(y2_coordinate_line1)
    distance_from_center_point_3 = abs(x1_coordinate_line2) + abs(y1_coordinate_line2)
    distance_from_center_point_4 = abs(x2_coordinate_line2) + abs(y2_coordinate_line2)
    length_line_1 = (
        abs(x1_coordinate_line1)
        + abs(y1_coordinate_line1)
        + abs(x2_coordinate_line1)
        + abs(y2_coordinate_line1)
    )
    length_line_2 = (
        abs(x1_coordinate_line2)
        + abs(y1_coordinate_line2)
        + abs(x2_coordinate_line2)
        + abs(y2_coordinate_line2)
    )

    if length_line_1 >= length_line_2:
        if distance_from_center_point_1 <= distance_from_center_point_2:
            print(
                f"({floor(x1_coordinate_line1)}, {floor(y1_coordinate_line1)})({floor(x2_coordinate_line1)}, {floor(y2_coordinate_line1)})"
            )
        else:
            print(
                f"({floor(x2_coordinate_line1)}, {floor(y2_coordinate_line1)})({floor(x1_coordinate_line1)}, {floor(y1_coordinate_line1)})"
            )

    else:
        if distance_from_center_point_3 <= distance_from_center_point_4:
            print(
                f"({floor(x1_coordinate_line2)}, {floor(y1_coordinate_line2)})({floor(x2_coordinate_line2)}, {floor(y2_coordinate_line2)})"
            )
        else:
            print(
                f"({floor(x2_coordinate_line2)}, {floor(y2_coordinate_line2)})({floor(x1_coordinate_line2)}, {floor(y1_coordinate_line2)})"
            )


x_coordinate_point_1_line_1 = float(input())
y_coordinate_point_1_line_1 = float(input())
x_coordinate_point_2_line_1 = float(input())
y_coordinate_point_2_line_1 = float(input())
x_coordinate_point_1_line_2 = float(input())
y_coordinate_point_1_line_2 = float(input())
x_coordinate_point_2_line_2 = float(input())
y_coordinate_point_2_line_2 = float(input())

calculate_distance_from_center(
    x_coordinate_point_1_line_1,
    y_coordinate_point_1_line_1,
    x_coordinate_point_2_line_1,
    y_coordinate_point_2_line_1,
    x_coordinate_point_1_line_2,
    y_coordinate_point_1_line_2,
    x_coordinate_point_2_line_2,
    y_coordinate_point_2_line_2,
)
