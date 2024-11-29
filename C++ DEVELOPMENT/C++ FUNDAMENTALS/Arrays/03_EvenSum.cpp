#include <iostream>

using namespace std;

const int MAX_SIZE = 99;


int main() {
    int size;
    cin >> size;

    int evenNumbersSum = 0;

    // Without arrays optimal solution
//    for (int i = 0; i < size; i++) {
//        int num;
//        cin >> num;
//
//        if (num % 2 == 0) {
//            evenNumbersSum += num;
//        }
//    }
//
//    cout << evenNumbersSum;

    // Solution 2 not optimal but with arrays
    int numbers[MAX_SIZE];

    for (int i = 0; i < size; i++) {
        cin >> numbers[i];
    }

    for (int i = 0; i < size; i++) {
        if (numbers[i] % 2 == 0) {
            evenNumbersSum += numbers[i];
        }
    }

    cout << evenNumbersSum;

    return 0;
}
