#include <iostream>
#include <cmath>

using namespace std;

int main() {

    int number;

    while (true) {
        cin >> number;

        if (number % 2 == 0) {
            cout << "The number is: " << abs(number) << endl;
            break;
        }
        else {
            cout << "Please write an even number." << endl;
        }
    }

    return 0;
}
