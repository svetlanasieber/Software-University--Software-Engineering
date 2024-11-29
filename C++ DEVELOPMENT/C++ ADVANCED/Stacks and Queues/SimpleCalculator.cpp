#include <iostream>
#include <sstream>
#include <string>
#include <stack>

using namespace std;

int main()
{
    string input;
    getline(cin, input);

    istringstream ss(input);

    stack<int> numbers;
    stack<char> ops;

    int num;
    while (ss >> num) {
        numbers.push(num);

        char op;
        if (ss >> op) 
            ops.push(op);
        
    }

    // numbers: 2 5 10 2 1
    // ops:     + + - -

    // 1) 2 1 - >> 1 >> 2 5 10 1
    // 2) 10 1 - >> 9 >> 2 5 9
    // 3) 5 9 + >> 14 >> 2 14
    // 4) 2 14 + >> 16 >> 16

    int result = 0;
    while (!ops.empty()) {
        char operation = ops.top();
        ops.pop();

        int num;
        num = numbers.top(); numbers.pop();

       
        if (operation == '+') {
            result += num;
        }
        else if (operation == '-') {
            result -= num;
        }

    }
    if (!numbers.empty()) {
        result += numbers.top();
        numbers.pop();
    }
    
    
    cout << result << endl;

    return 0;

}
