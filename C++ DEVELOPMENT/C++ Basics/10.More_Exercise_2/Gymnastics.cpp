#include <iostream>

using namespace std;

int main(){

	string country;
	getline(cin, country);
	
	string tool;
	getline(cin, tool);
	
	double difficulty;
	double artisticity; 
	
	 
	
	if( country == "Russia" ){
			if(tool == "ribbon") {
				difficulty = 9.100;
				artisticity = 9.400;
			}else if(tool == "hoop") {
				difficulty = 9.300;
				artisticity = 9.800;
			}else{
				difficulty = 9.600;
				artisticity = 9.000;
			}
	}else if(country == "Bulgaria") {
			if(tool == "ribbon") {
				difficulty = 9.600;
				artisticity = 9.400;
			}else if(tool == "hoop") {
				difficulty = 9.550;
				artisticity = 9.750;
			}else{
				difficulty = 9.500;
				artisticity = 9.400;
			}
	}else{
			if(tool == "ribbon") {
				difficulty = 9.200;
				artisticity = 9.500;
			}else if(tool == "hoop") {
				difficulty = 9.450;
				artisticity = 9.350;
			}else{
				difficulty = 9.700;
				artisticity = 9.150;
			}
	}
		
	double score = difficulty + artisticity;
	double percentage = (20 - score) * 100 / 20.0;	 
	
	cout.setf(ios::fixed);
	cout.precision(3);
	
	cout << "The team of " << country << " get " << score << " on " << tool << "." << endl;
	
	cout.setf(ios::fixed);
	cout.precision(2);
	
	cout << percentage << "%" << endl;
}