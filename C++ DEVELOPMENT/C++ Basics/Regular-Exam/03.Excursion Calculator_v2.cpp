#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main() {
    
    int numberOfPeople;
    string season;

   
    cin >> numberOfPeople >> season;

    
    double excursionPrice = 0.0;

    
    if (numberOfPeople <= 5) {
        if (season == "spring")
            excursionPrice = numberOfPeople * 50.0;
        else if (season == "summer")
            excursionPrice = numberOfPeople * 48.5;
        else if (season == "autumn")
            excursionPrice = numberOfPeople * 60.0;
        else if (season == "winter")
            excursionPrice = numberOfPeople * 86.0;
    }
    else {
        if (season == "spring")
            excursionPrice = numberOfPeople * 48.0;
        else if (season == "summer")
            excursionPrice = numberOfPeople * 45.0;
        else if (season == "autumn")
            excursionPrice = numberOfPeople * 49.5;
        else if (season == "winter")
            excursionPrice = numberOfPeople * 85.0;
    }

    
    if (season == "summer")
        excursionPrice *= 0.85; 
    else if (season == "winter")
        excursionPrice *= 1.08; 

    
    cout << fixed << setprecision(2) << excursionPrice << " leva." << endl;

    return 0;
}
