#include <iostream>

using namespace std;

inline int findRectangleArea(int a, int b) {
    return a * b;
}

int main() {
    int sideA, sideB;
    cin >> sideA >> sideB;

    cout << findRectangleArea(sideA, sideB);

    return 0;
}
