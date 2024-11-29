#include <iostream>
#include <string>

using namespace std;

int main()
{
	string drink;
	cin >> drink;	
	
	string sugar;
	cin >> sugar;
	
	int quantity;
	cin >> quantity;
	
	double price = 0.0;
	
	if( drink == "Espresso"){

		if(sugar == "Without"){
	
			price = 0.9 * quantity;
			price -= price * 0.35;
			if( quantity >= 5) price -= price*0.25;
			if(price > 15) price -= price * 0.2;
		
		}else if(sugar == "Normal"){
	
			price = 1.0 * quantity;
			if( quantity >= 5) price -= price*0.25;
			if(price > 15) price -= price * 0.2;
	
		}else if(sugar == "Extra"){
	
			price = 1.2 * quantity;
			if( quantity >= 5) price -= price*0.25;
			if(price > 15) price -= price * 0.2;
	
		}

	}else if(drink == "Cappuccino"){

		if(sugar == "Without"){
	
			price = 1.0 * quantity;
			price -= price * 0.35;
			if(price > 15) price -= price * 0.2;
	
		}else if(sugar == "Normal"){
	
			price = 1.2 * quantity;
			if(price > 15) price -= price * 0.2;
	
		}else if(sugar == "Extra"){
	
			price = 1.6 * quantity;
			if(price > 15) price -= price * 0.2;
	
		}

	} else if(drink == "Tea"){

		if(sugar == "Without"){
	
			price = 0.5 * quantity;
			price -= price * 0.35;
			if(price > 15) price -= price * 0.2;
	
		}else if(sugar == "Normal"){
	
			price = 0.6 * quantity;
			if(price > 15) price -= price * 0.2;
	
		}else if(sugar == "Extra"){
	
			price = 0.7 * quantity;
			if(price > 15) price -= price * 0.2;
	
		}

	}

	cout.setf(ios::fixed);
	cout.precision(2);	
	
	cout << "You bought " << quantity << " cups of " << drink << " for " << price << " lv." << endl;
	 
	return 0;
}