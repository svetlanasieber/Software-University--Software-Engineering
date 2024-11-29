#include <iostream>
#include <cmath>

using namespace std;

void printPower(int a, int b) {
    int powerResult = pow(a, b);
    cout << powerResult;
}

int main() {
    int num1, num2;
    cin >> num1 >> num2;

    printPower(num1, num2);

    return 0;
}