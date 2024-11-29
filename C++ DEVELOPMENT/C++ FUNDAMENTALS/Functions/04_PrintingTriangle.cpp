#include <iostream>

using namespace std;

void printRow(int row) {
    for (int currNum = 1; currNum <= row; currNum++) {
        cout << currNum << " ";
    }

    cout << endl;
}

void printUpperTrianglePart(int size) {
    for (int row = 1; row <= size; row++) {
        printRow(row);
    }
}

void printLowerTrianglePart(int size) {
    for (int row = size - 1; row > 0; row--) {
        printRow(row);
    }
}

void printTriangle(int size) {
    printUpperTrianglePart(size);
    printLowerTrianglePart(size);
}

int main() {
    int num;
    cin >> num;

    printTriangle(num);

    return 0;
}