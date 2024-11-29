from math import ceil, floor

paint_boxes = int(input())
wallpaper_rows = int(input())
one_gloves_price = float(input())
one_brush_price = float(input())

paint_price = paint_boxes * 21.50
wallpaper_price = wallpaper_rows * 5.20

gloves_count = ceil(wallpaper_rows * 0.35)
brush_count = floor(paint_boxes * 0.48)

gloves_price = gloves_count * one_gloves_price
brush_price = brush_count * one_brush_price

total_price = paint_price + wallpaper_price + gloves_price + brush_price

delivery_price = total_price / 15

print(f"This delivery will cost {delivery_price:.2f} lv.")
