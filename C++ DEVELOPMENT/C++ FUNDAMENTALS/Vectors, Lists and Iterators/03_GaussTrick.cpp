#include <iostream>
#include <vector>

using namespace std;

int task3() {
    int num;
    vector<int> numbers;

    while(cin >> num) numbers.push_back(num);

    for (size_t i = 0; i <= (numbers.size() - 1) / 2; i++) {
        size_t reverseIdx = numbers.size() - 1 - i;

        if (reverseIdx == i) {
            cout << numbers[i] << " ";
        }
        else {
            cout << numbers[i] + numbers[reverseIdx] << " ";
        }
    }

    return 0;
}
