#include <iostream>

using namespace std;

int main()
{
	double sales;
	cin >> sales;
	cin.ignore();
	
	int hearthstone = 0;
	int fornite = 0;
	int overwatch = 0;
	int others = 0;
	
	for(int i = 0; i < sales; i++){
		
		string game;
		getline(cin,game);
		
		if(game == "Hearthstone"){
			hearthstone++;
		}else if(game == "Fornite"){
			fornite++;
		}else if(game == "Overwatch"){
			overwatch++;
		}else{
			others++;
		}
	}
	
	cout.setf(ios::fixed);
	cout.precision(2);
	
	cout << "Hearthstone - " << hearthstone * 100 / sales << "%" << endl;
	cout << "Fornite - " << fornite * 100 / sales << "%" << endl;
	cout << "Overwatch - " << overwatch * 100 / sales << "%" << endl;
	cout << "Others - " << others * 100 / sales << "%" << endl;
	
	return 0;
}