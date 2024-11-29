#include <iostream>
#include <cmath>

using namespace std;

int main()
{
	string input;
	getline(cin,input);
	
	int maxPower = 0;
		
	string winWord = "";
	
	while( input != "End of words" ){
	
		int n = input.length();
		int values = 0;
		
		switch(input[0]){

				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'y':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
				case 'Y':
					for(int i = 0; i < n; i++){
					
						values += input[i];
					}
					values *= n;
					break;
					
				default:
					for(int i = 0; i < n; i++){
					
						values += input[i];
					}
					values = (int)floor(values/n);
					break;
		}
			
		if(values >= maxPower){
				maxPower = values;
				winWord = input;
		} 	 
		getline(cin,input); 
	}
	cout << "The most powerful word is " << winWord << " - " << maxPower << endl;
	
	return 0;
}