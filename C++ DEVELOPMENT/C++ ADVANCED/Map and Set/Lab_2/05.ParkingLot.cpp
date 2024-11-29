#include <map>
#include <set>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>


using namespace std;

int main(void) {

    set<string> parkingLot;

    while(1) {
        string row;
        getline(cin, row);
        if (row == "END")
            break;

        istringstream istr(row);

        string cmd;
        string registr;

        istr >> cmd >> registr;

        if (cmd == "IN,") {
            // the car enters the parking lot
            parkingLot.insert(registr);
        } else {
            // the car exits the parking lot
            parkingLot.erase(registr);
        }
    }

    if (parkingLot.size() == 0)
        cout << "Parking Lot is Empty" << endl;
    else 
        for(string reg : parkingLot)
            cout << reg << endl;

    return 0;
}
