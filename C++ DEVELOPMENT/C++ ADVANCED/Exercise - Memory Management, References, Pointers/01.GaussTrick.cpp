#include <iostream>
#include <vector>
#include <sstream>
#include <string>

using namespace std;

void printVector(const vector<int>& myVec) {
    for (int el : myVec)
        cout << el << " ";
    cout << endl;
}

int main()
{
    string input;
    getline(cin, input);

    vector<int> numbers;
    vector<int> numbersSums;

    istringstream ss(input);
    int num;

    while (ss >> num)
        numbers.push_back(num);

    while (numbers.size() > 0) {
        int sum = numbers.front();
        numbers.erase(numbers.begin());
        if (numbers.size() >= 1) {
            sum += numbers.back();
            numbers.pop_back();
        }
        numbersSums.push_back(sum);
    }

    printVector(numbersSums);

    return 0;
}
