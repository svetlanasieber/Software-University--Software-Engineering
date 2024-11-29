#include <iostream>
#include <iomanip>

using namespace std;

int main() {
   
    double tshirtPrice, requiredAmount;
    cin >> tshirtPrice >> requiredAmount;

   
    double shortsPrice = tshirtPrice * 0.75;
    double socksPrice = shortsPrice * 0.20;
    double buttonsPrice = (tshirtPrice + shortsPrice) * 2;

   
    double totalPrice = tshirtPrice + shortsPrice + socksPrice + buttonsPrice;

   
    double discountedPrice = totalPrice - (totalPrice * 0.15);

    if (discountedPrice >= requiredAmount) {
        cout << "Yes, he will earn the world-cup replica ball!" << endl;
        cout << "His sum is " << fixed << setprecision(2) << discountedPrice << " lv." << endl;
    }
    else {
        cout << "No, he will not earn the world-cup replica ball." << endl;
        cout << "He needs " << fixed << setprecision(2) << requiredAmount - discountedPrice << " lv. more." << endl;
    }

   
}
