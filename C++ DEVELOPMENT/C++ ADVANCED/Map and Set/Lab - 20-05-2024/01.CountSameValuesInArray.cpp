#include <iostream>
#include <string>
#include <utility>
#include <map>
#include <sstream>
#include <iterator>
#include <queue>

using namespace std;

int main()
{
    string input;
    getline(cin, input);

    istringstream ss(input);
    double value;

    queue<double> allValues;

    while (ss >> value) {
        allValues.push(value);
    }

    map<double, int> valuesMap;
    vector<double> valuesVector;
    while (!allValues.empty()) {
        double val = allValues.front(); allValues.pop();
        if (valuesMap.find(val) != valuesMap.end()) {
            valuesMap[val]++;
        }
        else {
            valuesMap[val] = 1;
            valuesVector.push_back(val);
        }
    }

    for (int i = 0; i < valuesVector.size(); i++) {
        double key = valuesVector[i];
        cout << key << " - " << valuesMap[key] << " times" << endl;
    }

    
  

    return 0;
}
