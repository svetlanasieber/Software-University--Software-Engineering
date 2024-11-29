#include <iostream>

using namespace std;

const int MAX_SIZE = 99;

void reverseArray(string words[], int wordsCount) {
    for (int i = 0; i < wordsCount / 2; i++) {
        string temp = words[i];  // we get the leftmost word
        words[i] = words[wordsCount - i - 1];
        words[wordsCount - i - 1] = temp;
    }
}

int main() {  // hello => oellh => olleh
    string words[MAX_SIZE];

    int wordsCount;
    cin >> wordsCount;

    for (int i = 0; i < wordsCount; i++) {
        cin >> words[i];
    }

    reverseArray(words, wordsCount);

    for (int i = 0; i < wordsCount - 1; i++) {
        cout << words[i] << " ";
    }

    cout << words[wordsCount - 1];

    return 0;
}