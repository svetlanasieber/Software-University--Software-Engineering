#include <iostream>
#include <set>
#include <string>
#include <sstream>
#include <list>

using namespace std;

int main()
{
    int n;
    cin >> n; cin.ignore();

    set<string> setNames;
    list<string> uniqueNames;


    for (int i = 0; i < n; i++) {
        string name;
        cin >> name;

        if (setNames.find(name) == setNames.end()) {
            setNames.insert(name);
            uniqueNames.push_back(name);
        }
    }

    for (string name : uniqueNames) {
        cout << name << endl;
    }

    return 0;
}
