#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;


bool isSquare(int num) {
    int root = static_cast<int>(sqrt(num));
    return root * root == num;
}

int main() {
    vector<int> numbers;
    vector<int> squares;
    int number;


    while (cin >> number) {
        numbers.push_back(number);
    }


    for (int num : numbers) {
        if (isSquare(num)) {
            squares.push_back(num);
        }
    }

    sort(squares.rbegin(), squares.rend());


    for (int sq : squares) {
        cout << sq << " ";
    }
    cout << endl;

    return 0;
}