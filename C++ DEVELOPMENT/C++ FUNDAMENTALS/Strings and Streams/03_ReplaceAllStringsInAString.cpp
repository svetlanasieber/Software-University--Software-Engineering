#include <iostream>
#include <string>

using namespace std;

int main() {
    string toRemove;
    string text;

    getline(cin, toRemove);
    getline(cin, text);

    while (true) {
        int pos = text.find(toRemove);

        if (pos == string::npos) {
            break;
        }

        text.erase(pos, toRemove.size());
    }

    cout << text << endl;

    return 0;
}
