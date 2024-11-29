#include <iostream>
#include <string>
#include <cctype>

using namespace std;

int main() {

    string input;
    getline(cin, input);

    string numbers;
    string letters;
    string others;

    for (char symbol : input) {
        if (isdigit(symbol)) {
            numbers += symbol;
        }
        else if (isalpha(symbol)) {
            letters += symbol;
        }
        else {
            others += symbol;
        }
    }

    cout << numbers << endl;
    cout << letters << endl;
    cout << others << endl;

    return 0;
}