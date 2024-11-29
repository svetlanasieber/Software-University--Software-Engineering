#include <iostream>

using namespace std;

int main()
{
	int food;
	cin >> food;
	cin.ignore();
	
	food *= 1000;
	
	int eatenFood = 0;
	
	string input;
	getline(cin, input);
	
	while( input != "Adopted"){
	
		int eaten = std::stoi(input);
		
		eatenFood += eaten;
		
		getline(cin,input);
	}
	
	if(food >= eatenFood){
	cout << "Food is enough! Leftovers: " << food - eatenFood << " grams." << endl;
	}else{
	cout << "Food is not enough. You need " << eatenFood - food << " grams more."  <<  endl;
	}
	 
	return 0;
}