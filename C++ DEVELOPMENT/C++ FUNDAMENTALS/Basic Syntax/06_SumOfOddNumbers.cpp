#include <iostream>

using namespace std;

int task6() {
    int sumOfOddNumbers = 0;

    int oddNumbersCount;
    cin >> oddNumbersCount;

    for (int counter = 0; counter < oddNumbersCount; counter++) {
        int oddNumber = counter * 2 + 1;
        sumOfOddNumbers += oddNumber;

        cout << oddNumber << endl;
    }

    cout << "Sum: " << sumOfOddNumbers << endl;

    return 0;
}
