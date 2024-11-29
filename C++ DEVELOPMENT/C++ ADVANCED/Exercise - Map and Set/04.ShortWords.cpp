#include <iostream>
#include <string>
#include <set>
#include <sstream>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;


string toLowerCase(const string& str) {
    string lowerStr;
    for (char c : str) {
        lowerStr += tolower(c);
    }
    return lowerStr;
}

int main() {
    string line;
    getline(cin, line);

    istringstream istr(line);
    set<string> uniqueWords;  
    vector<string> shortWords; 

    string word;
    while (istr >> word) {
        string lowerWord = toLowerCase(word);
        if (lowerWord.length() < 5) {
            uniqueWords.insert(lowerWord);
        }
    }

    
    shortWords.assign(uniqueWords.begin(), uniqueWords.end());

    sort(shortWords.begin(), shortWords.end());

    // Print the words separated by a comma and a space
    for (size_t i = 0; i < shortWords.size(); i++) {
        if (i > 0) {
            cout << ", ";
        }
        cout << shortWords[i];
    }
    cout << endl;

    return 0;
}
