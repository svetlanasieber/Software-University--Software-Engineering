#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

using namespace std;

void printVector(const vector<int>& myVec, const string &message) {
    if (myVec.size() > 0) {
        for (int el : myVec)
            cout << el << " ";
    }
    else {
        cout << message;
    }
    cout << endl;
}

int main()
{
    string input;
    getline(cin, input);

    vector<int> numbers;

    istringstream ss(input);
    int num;

    while (ss >> num) {
        if (num >= 0)
            numbers.push_back(num);
    }

    reverse(numbers.begin(), numbers.end());
        
    printVector(numbers, "empty");
   
    return 0;
}