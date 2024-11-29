#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<double> numbers;
    double number;

    while (cin >> number) {
        numbers.push_back(number);
    }

    sort(numbers.rbegin(), numbers.rend());

    int count = min(3, (int)numbers.size());
    for (int i = 0; i < count; i++) {
        cout << numbers[i] << " ";
    }

    cout << endl;
    return 0;
}

