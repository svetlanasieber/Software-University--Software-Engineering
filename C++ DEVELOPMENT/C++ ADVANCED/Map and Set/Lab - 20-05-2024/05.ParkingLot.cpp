#include <string>
#include <iostream>
#include <set>
#include <sstream>
#include <algorithm>
#include <vector>

using namespace std;

// 100/100, just zero test 1 is wrong

int main()
{
    set<string> parkingLot;
    vector<string> parking;


    while (true) {
        string input;
        getline(cin, input);

        if (input == "END")
            break;

        istringstream ss(input);
        string command, carNumber;
        ss >> command;
        ss >> carNumber;

        if (command == "IN,") {
            parkingLot.insert(carNumber);
            if (find(parking.begin(), parking.end(), carNumber) == parking.end())
                parking.push_back(carNumber);
        }
        else if (command == "OUT,") {
            parkingLot.erase(carNumber);

        }
    }

    if (parkingLot.empty()) {
        cout << "Parking Lot is Empty" << endl;
        return 0;
    }

    for (int i = 0; i < parking.size(); i++) {
        if (parkingLot.find(parking[i]) != parkingLot.end()) {
            cout << parking[i] << endl;
        }
    }

    return 0;
}
