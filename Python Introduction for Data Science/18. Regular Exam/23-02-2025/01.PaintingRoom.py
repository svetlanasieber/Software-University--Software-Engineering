import math

paint_of_cans = int(input())
wallpaper_rolls = int(input())
glove_price = float(input())
brush_price = float(input())


paint_price = 21.50
wallpaper_price = 5.20


gloves_needed = math.ceil(wallpaper_rolls * 0.35)
brushes_needed = math.floor(paint_of_cans * 0.48)


total_paint = paint_of_cans * paint_price
total_wallpaper = wallpaper_rolls * wallpaper_price
total_glove = gloves_needed * glove_price
total_brush = brushes_needed * brush_price


total_cost = total_paint + total_wallpaper + total_glove + total_brush
delivery_cost = total_cost / 15


print(f"This delivery will cost {delivery_cost:.2f} lv.")
