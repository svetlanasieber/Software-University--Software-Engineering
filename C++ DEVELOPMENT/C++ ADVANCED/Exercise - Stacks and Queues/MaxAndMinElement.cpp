#include <iostream>
#include <sstream>
#include <string>
#include <stack>

using namespace std;

void printMaxElement(stack<int> numbers) {
    int maxElement = -999999;
    int current;
    while (!numbers.empty()) {
        current = numbers.top(); numbers.pop();
        if (current >= maxElement)
            maxElement = current;
    }
    cout << maxElement << endl;
}

void printMinElement(stack<int> numbers) {
    int minElement = 999999;
    int current;
    while (!numbers.empty()) {
        current = numbers.top(); numbers.pop();
        if (current <= minElement)
            minElement = current;
    }
    cout << minElement << endl;
}

int main()
{
    int n;
    cin >> n;

    stack<int> numbers;

    for (; n != 0; n--) {
        int command;
        cin >> command;

        if (command == 1) {
            int num;
            cin >> num;
            numbers.push(num);
        }
        else if (command == 2) {
            if (!numbers.empty())
                numbers.pop();
        }
        else if (command == 3) {
            if (!numbers.empty())
                printMaxElement(numbers);
        }
        else if (command == 4) {
            if (!numbers.empty())
                printMinElement(numbers);
        }

    }

    while (!numbers.empty()) {
        cout << numbers.top();
        numbers.pop();
        if (!numbers.empty())
            cout << ", ";
    }
    cout << endl;
    
    return 0;
}
