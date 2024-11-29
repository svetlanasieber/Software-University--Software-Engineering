from math import ceil, floor


def calculate_material_cost(boxes, rows):
    paint_price = boxes * 21.50
    wallpaper_price = rows * 5.20
    return paint_price + wallpaper_price


def calculate_tools_cost(boxes, rows, gloves_price, brushes_price):
    gloves_count = ceil(rows * 0.35)
    brush_count = floor(boxes * 0.48)
    total_gloves_price = gloves_count * gloves_price
    total_brushes_price = brush_count * brushes_price
    return total_gloves_price + total_brushes_price


def calculate_delivery_cost(total_price):
    return total_price / 15


def main():
    paint_boxes = int(input())
    wallpaper_rows = int(input())
    one_gloves_price = float(input())
    one_brush_price = float(input())


    materials_cost = calculate_material_cost(paint_boxes, wallpaper_rows)


    tools_cost = calculate_tools_cost(paint_boxes, wallpaper_rows, one_gloves_price, one_brush_price)


    total_price = materials_cost + tools_cost
    delivery_price = calculate_delivery_cost(total_price)

    print(f"This delivery will cost {delivery_price:.2f} lv.")


if __name__ == "__main__":
    main()
