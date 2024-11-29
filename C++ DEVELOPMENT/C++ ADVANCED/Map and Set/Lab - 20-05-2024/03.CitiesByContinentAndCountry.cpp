#include <iostream>
#include <map>
#include <set>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;
    cin.ignore();  // To ignore the newline character after the number

    map<string, map<string, set<string>>> data;

    for (int i = 0; i < n; ++i) {
        string continent, country, city;
        cin >> continent >> country >> city;
        data[continent][country].insert(city);
    }

    for (const auto& continent : data) {
        cout << continent.first << ":" << endl;
        for (const auto& country : continent.second) {
            cout << "  " << country.first << " -> ";
            bool first = true;
            for (const auto& city : country.second) {
                if (!first) {
                    cout << ", ";
                }
                cout << city;
                first = false;
            }
            cout << endl;
        }
    }

    return 0;
}

