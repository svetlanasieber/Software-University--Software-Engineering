#include <map>
#include <set>
#include <vector>
#include <string>
#include <iostream>
#include <iomanip>
#include <sstream>


using namespace std;

int main(void) {

    map<string, vector<double> > data;

    int records;
    cin >> records;

    while(records--) {
        string name;
        cin >> name;
        double grade;
        cin >> grade;

        data[name].push_back(grade);
    }

    cout << fixed << setprecision(2);

    for(map<string, vector<double> >::iterator itB = data.begin(); itB != data.end(); itB++) {

        cout << itB->first << " -> ";

        vector<double> & vec = itB->second;
        double average = 0;

        for(double d : vec) {
            average += d;
            cout << d << " ";
        }

        cout << "(avg: " << average/vec.size() << ")" << endl;

    }

    return 0;
}
