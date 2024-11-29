#include <iostream>
#include <map>
#include <cstring>

using namespace std;

int main(void) {

    char buffer[5000];
    char * nextName = buffer;

    map<int, const char *> companies;

    string name;
    cin >> name;

    while(name != "end") {

        int id;
        cin >> id;

        strcpy(nextName, name.c_str());

        companies[id] = nextName;

        nextName += (strlen(nextName) + 1);

        cin >> name; // next company...
    }

    int id;

    cin >> id;

    auto res = companies.find(id);
    if (res == companies.end()) 
        cout << "[not found]" << endl;
    else
        cout << res->second << ' ' << res->first << endl;

    return 0;
}
