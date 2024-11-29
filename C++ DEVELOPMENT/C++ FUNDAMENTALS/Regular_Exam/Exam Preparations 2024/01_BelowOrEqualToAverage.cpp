#include <iostream>

using namespace std;

int main() {
    int size;
    cin >> size;

    int numbers[size];
    int belowOrEqualToAverageNumbers[size];

    int sumOfNumbers = 0;

    for (int i = 0; i < size; i++) {
        cin >> numbers[i];
        sumOfNumbers += numbers[i];
    }

    int averageValue = sumOfNumbers / size;
    int idx = 0;

    for (int i = 0; i < size; i++) {
        if (numbers[i] <= averageValue) {
            belowOrEqualToAverageNumbers[idx++] = numbers[i];
        }
    }

    int evenSum = 0, oddSum = 0;

    for (int i = 0; i < idx; i++) {
        if (i % 2 == 0) {
            evenSum += belowOrEqualToAverageNumbers[i];
        }
        else {
            oddSum += belowOrEqualToAverageNumbers[i];
        }
    }

    int productOfSums = evenSum * oddSum;

    cout << productOfSums << endl;

    return 0;
}
