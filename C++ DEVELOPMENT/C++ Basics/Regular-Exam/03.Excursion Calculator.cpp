#include <iostream>
#include <iomanip> 

using namespace std;

int main() {
    int tourists;
    string season;
    double pricePerTourist = 0;
    cin >> tourists >> season;

    
    if (season == "spring") {
        if (tourists > 5) {
            pricePerTourist = 48;
        }
        else {
            pricePerTourist = 50;
        }
    }
    else if (season == "summer") {
        if (tourists > 5) {
            pricePerTourist = 45;
        }
        else {
            pricePerTourist = 48.50;
        }
    }
    else if (season == "autumn") {
        if (tourists > 5) {
            pricePerTourist = 49.50;
        }
        else {
            pricePerTourist = 60;
        }
    }
    else if (season == "winter") {
        if (tourists > 5) {
            pricePerTourist = 85;
        }
        else {
            pricePerTourist = 86;
        }
    }

    double finalPrice = pricePerTourist * tourists;

   
    if (season == "summer") {
        finalPrice *= 0.85;
    }
    else if (season == "winter") {
        finalPrice *= 1.08;
    }

   
    cout << fixed << setprecision(2) << finalPrice << " leva." << endl;

    return 0;
}