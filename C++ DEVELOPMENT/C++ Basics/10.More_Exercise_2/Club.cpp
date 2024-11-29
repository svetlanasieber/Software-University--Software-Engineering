#include <iostream>
#include <string>

using namespace std;

int main()
{
	double targetProfit;
	cin >> targetProfit;
	cin.ignore();
	
	string input;
	getline(cin,input);
	
	double realProfit = 0.0;
	
	while( input != "Party!" ){
		
		int cocktailPrice = input.length();
		
		int cocktailNumber; 
		cin >> cocktailNumber;
		cin.ignore();
		
		int totalPrice = cocktailPrice * cocktailNumber;
		
		if(totalPrice % 2 == 1) {
			
			double price = totalPrice - totalPrice * 0.25;
			realProfit += price;
			
		}else{
			realProfit += totalPrice;
		}
		
		if(realProfit >= targetProfit) break;
		
		getline(cin,input);	

		if(input.empty()) break;	
	}
	
	cout.setf(ios::fixed);
	cout.precision(2);
	
	if(realProfit < targetProfit){
			cout << "We need " << targetProfit - realProfit <<" leva more." << endl;
			cout << "Club income - " << realProfit << " leva." << endl;	
	}else{
			cout << "Target acquired." << endl;
			cout << "Club income - " << realProfit << " leva." << endl;	
	}
	return 0;

}