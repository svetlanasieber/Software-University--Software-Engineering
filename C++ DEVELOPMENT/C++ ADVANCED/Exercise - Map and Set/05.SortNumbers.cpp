#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<double> numbers;
    double number;

   
    while (cin >> number) {
        numbers.push_back(number);
    }

  
    sort(numbers.begin(), numbers.end());

  
    for (size_t i = 0; i < numbers.size(); ++i) {
        if (i > 0) {
            cout << " <= ";
        }
        cout << numbers[i];
    }
    cout << endl;

    return 0;
}

