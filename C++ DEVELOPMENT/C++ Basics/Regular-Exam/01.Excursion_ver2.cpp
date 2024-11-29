#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    
    const double NIGHT_COST = 20.0;       
    const double TRANSPORT_COST = 1.60;   
    const double MUSEUM_COST = 6.0;       


   
    int groupSize, nights, transportCards, museumTickets;

    cin >> groupSize >> nights >> transportCards >> museumTickets;

    
    double perPersonTotal = (nights * NIGHT_COST) + (transportCards * TRANSPORT_COST) + (museumTickets * MUSEUM_COST);

    double groupTotal = perPersonTotal * groupSize;

   
    double totalWithExtra = groupTotal + (groupTotal * 0.25);

    
    cout << fixed << std::setprecision(2) << totalWithExtra << endl;


    return 0;
}
