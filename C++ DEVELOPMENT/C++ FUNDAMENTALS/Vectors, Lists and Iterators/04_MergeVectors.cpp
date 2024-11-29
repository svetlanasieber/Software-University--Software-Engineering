#include <iostream>
#include <vector>
#include <sstream>
#include <string>

using namespace std;

void readVector(vector<int>& numbers) {
    string line;
    getline(cin, line);

    istringstream is(line);

    int num;
    while (is >> num) numbers.push_back(num);
}

vector<int> mergeVectors(const vector<int>& numbers1, const vector<int>& numbers2) {
    vector<int> mergedVector;

    int idx = 0;
    while (idx < numbers1.size() && idx < numbers2.size()) {
        mergedVector.push_back(numbers1[idx]);
        mergedVector.push_back(numbers2[idx]);

        idx++;
    }

    while (idx < numbers1.size()) {
        mergedVector.push_back(numbers1[idx]);
        idx++;
    }

    while (idx < numbers2.size()) {
        mergedVector.push_back(numbers2[idx]);
        idx++;
    }

    return mergedVector;
}

void printVector(vector<int>& myVector) {
    for (int el : myVector) {
        cout << el << " ";
    }
}

int main() {
    vector<int> numbers1;
    vector<int> numbers2;

    readVector(numbers1);
    readVector(numbers2);

    vector<int> mergedVector = mergeVectors(numbers1, numbers2);

    printVector(mergedVector);

    return 0;
}