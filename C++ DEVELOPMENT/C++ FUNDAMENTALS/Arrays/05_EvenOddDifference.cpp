#include <iostream>

using namespace std;

const int MAX_SIZE = 99;

int main() {
    int numbers[MAX_SIZE];

    int size;
    cin >> size;

    for (int i = 0; i < size; i++) {
        cin >> numbers[i];
    }

    int evenSum = 0;
    int oddSum = 0;

    for (int i = 0; i < size; i++) {
        if (numbers[i] % 2 == 0) {
            evenSum += numbers[i];
        }
        else {
            oddSum += numbers[i];
        }
    }

    cout << evenSum - oddSum << endl;

    return 0;
}