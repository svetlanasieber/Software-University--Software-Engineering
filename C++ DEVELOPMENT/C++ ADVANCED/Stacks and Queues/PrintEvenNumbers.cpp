#include <iostream>
#include <sstream>
#include <string>
#include <queue>

using namespace std;

queue<int> readInput() {
    queue<int> numbers;

    string input;
    getline(cin, input);

    istringstream ss(input);
    int num;

    while (ss >> num) {
        numbers.push(num);
    }

    return numbers;
}

int main()
{
    queue<int> numbers = readInput();

    while (!numbers.empty()) {
        int num = numbers.front();
        numbers.pop();

        if (num % 2 == 0) {
            cout << num;
            if (!numbers.empty())
                cout << ", ";
        }
    
    }

    cout << endl;
}
