#include <iostream>
#include <string>
#include <map>
#include <utility>
#include <sstream>

using namespace std;

int main() {

    map<double, unsigned> numbers;

    string line;
    getline(cin, line);

    istringstream istr(line);

    double tmp;
    while (istr >> tmp)
        numbers[tmp]++;

    for (const pair<double, unsigned>& curr : numbers) // Corrected syntax
        cout << curr.first << " -> " << curr.second << endl;

    return 0;
}
