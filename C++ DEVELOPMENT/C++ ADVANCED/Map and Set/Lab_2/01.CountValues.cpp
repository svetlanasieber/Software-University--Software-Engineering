#include <map>
#include <set>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>

using namespace std;

int main() {

    // double -> count their occurrences
    map<double, unsigned> occurrences;
    vector<double> order;

    string buff;
    getline(cin, buff);
    istringstream istr(buff);

    double curr;
    while(istr >> curr) {
        if (occurrences.find(curr) == occurrences.end()) {
            order.push_back(curr);
        }
        occurrences[curr]++;
    }

/*    for(vector<double>::iterator itB = order.begin(); itB != order.end(); itB++) {
        double val = *itB;
        ....
    }
*/

    for(double val : order) {
        cout << val << " - " << occurrences[val] << " times" << endl;
    }

    return 0;
}
