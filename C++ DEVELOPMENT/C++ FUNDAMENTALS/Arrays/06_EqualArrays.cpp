#include <iostream>

using namespace std;

const int MAX_SIZE = 99;

void readArray(int numbers[], int size) {
    for (int i = 0; i < size; i++) {
        cin >> numbers[i];
    }
}

int main() {
    int numbers1[MAX_SIZE];  // 0x...123
    int numbers2[MAX_SIZE];  // 0x...567

    int size;
    cin >> size;

    readArray(numbers1, size);
    readArray(numbers2, size);

    int sum = 0;

    for (int i = 0; i < size; i++) {
        if (numbers1[i] == numbers2[i]) {
            sum += numbers1[i];
        }
        else {
            cout << "Arrays are not identical. Found difference at " << i << " index." << endl;
            return 0;
        }
    }

    cout << "Arrays are identical. Sum: " << sum << endl;

    return 0;
}