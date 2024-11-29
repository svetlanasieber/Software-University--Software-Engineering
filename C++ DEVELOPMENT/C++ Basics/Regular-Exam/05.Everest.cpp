#include <iostream>
#include <string>
#include <algorithm> // For transform
using namespace std;

int main() {
    string command;
    int daysCounter = 1;
    int metersCounter = 5364;
    bool isSucceeded = false;

    while (true) {
        cin >> command;
        if (command == "END") {
            break;
        }

        string isSpendingTheNight = command;
        transform(isSpendingTheNight.begin(), isSpendingTheNight.end(), isSpendingTheNight.begin(), ::tolower);
        if (isSpendingTheNight == "yes") {
            daysCounter++;
        }

        int climbedMeters;
        cin >> climbedMeters;
        if (daysCounter > 5) {
            isSucceeded = false;
            break;
        }
        metersCounter += climbedMeters;

        if (metersCounter >= 8848) {
            isSucceeded = true;
            break;
        }
    }

    if (isSucceeded) {
        cout << "Goal reached for " << daysCounter << " days!" << endl;
    }
    else {
        cout << "Failed!" << endl;
        cout << metersCounter << endl;
    }

    return 0;
}
