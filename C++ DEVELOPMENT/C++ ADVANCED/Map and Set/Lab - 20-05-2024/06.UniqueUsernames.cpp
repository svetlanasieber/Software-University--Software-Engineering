#include <iostream>
#include <set>
#include <string>

using namespace std;

int main() {
    int N;
    cin >> N;  // Reading the number of usernames to input
    cin.ignore();  // Ignore the newline character after reading integer

    set<string> usernames;

    string username;
    for (int i = 0; i < N; ++i) {
        getline(cin, username);
        usernames.insert(username);  // Set will automatically ignore duplicates
    }

    // Output all unique usernames in sorted order
    for (const string& name : usernames) {
        cout << name << endl;
    }

    return 0;
}

