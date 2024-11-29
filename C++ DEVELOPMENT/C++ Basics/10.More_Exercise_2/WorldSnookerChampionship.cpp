#include <iostream>

using namespace std;

int main(){

	string round;
	getline(cin, round);
	
	string ticket;
	getline(cin, ticket);
	
	int numberTickets;
	cin >> numberTickets;
	cin.ignore();
	
	char tropheyPic;
	cin >> tropheyPic;
	cin.ignore();
	
	double ticketsPrice = 0.0;
	
	if( round == "Quarter final" ){
			if(ticket == "Standard") {
				ticketsPrice = numberTickets * 55.50;
			}else if(ticket == "Premium") {
				ticketsPrice = numberTickets * 105.20;
			}else{
				ticketsPrice = numberTickets * 118.90;
			}
		}else if(round == "Semi final") {
			if(ticket == "Standard") {
				ticketsPrice = numberTickets * 75.88;
			}else if(ticket == "Premium") {
				ticketsPrice = numberTickets * 125.22;
			}else{
				ticketsPrice = numberTickets * 300.40;
			}
		}else{
			if(ticket == "Standard") {
				ticketsPrice = numberTickets * 110.10;
			}else if(ticket == "Premium") {
				ticketsPrice = numberTickets * 160.66;
			}else{
				ticketsPrice = numberTickets * 400;
			}
		}
		
		if(ticketsPrice > 4000){
			ticketsPrice -= ticketsPrice * 0.25;
		}else{
			if(ticketsPrice > 2500) ticketsPrice -= ticketsPrice * 0.1;
			if(tropheyPic == 'Y') ticketsPrice += numberTickets * 40;
		}
	
	cout.setf(ios::fixed);
	cout.precision(2);
	
	cout << ticketsPrice << endl;
}