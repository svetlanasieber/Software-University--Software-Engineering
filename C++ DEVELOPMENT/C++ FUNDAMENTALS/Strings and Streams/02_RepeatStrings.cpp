#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main() {

    ostringstream result;
    string str;

    while (cin >> str) {
        int count = str.length();

        while (count--) {
            result << str;
        }
    }

    cout << result.str();

    return 0;
}