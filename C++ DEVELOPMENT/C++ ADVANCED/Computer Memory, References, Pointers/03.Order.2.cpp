#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

bool compareCompanies(const char * data1, const char * data2) {
    // returns true if data1 < data2

    int * intData1 = (int *)data1;
    int * intData2 = (int *)data2;

    return *intData1 < *intData2;
}

void printCompany(const char * data) {

    const int *id = (const int *)data;
    const char *name = (data + sizeof(int));

    cout << name << ' ' << *id << endl;
}

int main(void) {

    char buffer[5000];
    char * nextData = buffer;

    vector<const char *> companies;

    string name;
    cin >> name;

    while(name != "end") {

        int id;
        cin >> id;

        companies.push_back(nextData);

        int *idP = (int *)nextData;
        *idP = id;
        nextData += sizeof(id);

        strcpy(nextData, name.c_str());
        nextData += (strlen(nextData) + 1);

        cin >> name; // next company...
    }

    sort(companies.begin(), companies.end(), compareCompanies);
    
    for(const char * data : companies)
        printCompany(data);

    return 0;
}
