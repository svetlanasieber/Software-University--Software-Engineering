#include <iostream>

using namespace std;

void signCheck(int number) {
    if (number > 0) {
        cout << "The number " << number << " is positive.";
    }
    else if (number < 0) {
        cout << "The number " << number << " is negative.";
    }
    else {
        cout << "The number " << number << " is zero.";
    }
}

int main() {
    int num;
    cin >> num;

    signCheck(num);

    return 0;
}