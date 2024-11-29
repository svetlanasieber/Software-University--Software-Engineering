#include <iostream>
#include <string>

using namespace std;

void printReversedWord(const string& str) {
    size_t lastIndex = str.length() - 1;

    cout << str << " = ";

    for (int i = lastIndex; i >= 0; i--) {
        cout << str[i];
    }

    cout << endl;
}

int main() {
    string str;

    while (cin >> str) {
        if (str == "end") break;
        printReversedWord(str);
    }

    return 0;
}