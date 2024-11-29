#include <iostream>
#include <string>

using namespace std;

int main() {
    string vowels = "aeiou";

    string line;
    getline(cin, line);

    for (int i = 0; i < line.length(); i++) {
        if (vowels.find(line[i]) == string::npos) {
            while (line[i] == line[i + 1]) {
                line.erase(i + 1, 1);
            }
        }
    }

    cout << line;

    return 0;
}