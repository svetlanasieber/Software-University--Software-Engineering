#include <iostream>
#include <climits>
#include <algorithm>

using namespace std;

// Solution 1
//int findMinNumber(int a, int b, int c) {
//    int minNumber = INT_MAX;
//
//    if (a < minNumber) {
//        minNumber = a;
//    }
//    if (b < minNumber) {
//        minNumber = b;
//    }
//    if (c < minNumber) {
//        minNumber = c;
//    }
//
//    return minNumber;
//}

// Solution 2
//int findMinNumber(int a, int b) {
//    return (a < b ? a : b);
//}
//
//int findMinNumber(int a, int b, int c) {
//    return findMinNumber(a, findMinNumber(b, c));
//}

// Solution 3
int findMinNumber(int a, int b, int c) {
    return min(a, min(b, c));
}

int main() {
    int a, b, c;
    cin >> a >> b >> c;

    cout << findMinNumber(a, b, c);

    return 0;
}