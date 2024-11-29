def calculate_gladiator_expenses():
  
    lost_fights = int(input())
    helmet_price = float(input())
    sword_price = float(input())
    shield_price = float(input())
    armor_price = float(input())

    expenses = 0.0
    shield_breaks = 0

   
    for fight in range(1, lost_fights + 1):
        helmet_broken = False
        sword_broken = False

        if fight % 2 == 0:  # helmet breaks every 2nd lost fight
            expenses += helmet_price
            helmet_broken = True
        if fight % 3 == 0:  # sword breaks every 3rd lost fight
            expenses += sword_price
            sword_broken = True

      
        if helmet_broken and sword_broken:
            expenses += shield_price
            shield_breaks += 1

       
        if (
            shield_breaks % 2 == 0
            and shield_breaks != 0
            and helmet_broken
            and sword_broken
        ):
            expenses += armor_price

 
    print(f"Gladiator expenses: {expenses:.2f} aureus")


calculate_gladiator_expenses()
