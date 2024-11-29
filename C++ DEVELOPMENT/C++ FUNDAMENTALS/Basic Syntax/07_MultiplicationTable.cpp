#include <iostream>

using namespace std;

int task7() {
    int number;
    cin >> number;

    for (int multiplier = 1; multiplier <= 10; multiplier++) {
        cout << number << " X " << multiplier << " = " << number * multiplier << endl;
    }

    return 0;
}
