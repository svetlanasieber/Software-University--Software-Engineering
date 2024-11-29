#include <iostream>
#include <string>

using namespace std;

int main()
{
	string fruit;
	cin >> fruit;
	
	string size;
	cin >> size;
	
	int quantity;
	cin >> quantity;
	
	double price = 0.0;
	
	if( fruit == "Watermelon" ){
	
		if( size == "big" ){
			
			price = 28.7 * quantity * 5;
			if(price >= 400 && price <= 1000) price -= price * 0.15;
			if(price > 1000) price -= price * 0.5;
		
		}else{
		
			price = 56 * quantity * 2;
			if(price >= 400 && price <= 1000) price -= price * 0.15;
			if(price > 1000) price -= price * 0.5;
		}
	
	}else if(fruit == "Mango"){
	
		if(size == "big"){
			
			price = 19.6 * quantity * 5;
			if(price >= 400 && price <= 1000) price -= price * 0.15;
			if(price > 1000) price -= price * 0.5;
		
		}else{
			
			price = 36.66 * quantity * 2;
			if(price >= 400 && price <= 1000) price -= price * 0.15;
			if(price > 1000) price -= price * 0.5;
		
		}
	
	}else if(fruit == "Pineapple"){
	
		if(size == "big"){
			
			price = 24.8 * quantity * 5;
			if(price >= 400 && price <= 1000) price -= price * 0.15;
			if(price > 1000) price -= price * 0.5;
		
		}else{
			
			price = 42.1 * quantity * 2;
			if(price >= 400 && price <= 1000) price -= price * 0.15;
			if(price > 1000) price -= price * 0.5;	
		}
	
	}else if(fruit == "Raspberry"){
	
		if(size == "big"){
			
			price = 15.2 * quantity * 5;;
			if(price >= 400 && price <= 1000) price -= price * 0.15;
			if(price > 1000) price -= price * 0.5;
		
		}else{
			
			price = 20 *  quantity * 2;
			if(price >= 400 && price <= 1000) price -= price * 0.15;
			if(price > 1000) price -= price * 0.5;
		
		}
	}

	cout.setf(ios::fixed);
	cout.precision(2);
	
	cout << price <<  " lv." << endl;
	return 0;
}