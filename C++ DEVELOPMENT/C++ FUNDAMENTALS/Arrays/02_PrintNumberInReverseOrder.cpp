#include <iostream>

using namespace std;

const int MAX_SIZE = 99;

int main() {
    int numbers[MAX_SIZE];

    int size;
    cin >> size;

    for (int row = 0; row < size; row++) {
        cin >> numbers[row];
    }

    for (int index = size - 1; index > 0; index--) {
        cout << numbers[index] << " ";
    }

    cout << numbers[0];

    cout << endl;

//    Second solution
//    for (int index = 0; index < size; index++) {
//        cout << numbers[size - index - 1] << " ";
//    }




    return 0;
}