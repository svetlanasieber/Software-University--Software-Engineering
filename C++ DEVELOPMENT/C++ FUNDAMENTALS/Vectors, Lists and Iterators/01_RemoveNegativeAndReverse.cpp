#include <iostream>
#include <vector>

using namespace std;


int task1() {
    vector<int> numbers;

    int num;
    while (cin >> num) {
        if (num > 0) {
            numbers.push_back(num);
        }
    }

    if (numbers.empty()) {
        cout << "empty" << endl;
        return 0;
    }

    for (int i = numbers.size() - 1; i >= 0; i--) {
        cout << numbers[i] << " ";
    }

    return 0;
}
