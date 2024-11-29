#include <iostream>
#include <sstream>
#include <string>
#include <stack>

using namespace std;

int main()
{
    int n, s, x;
    cin >> n >> s >> x;

    stack<int> numbers;
    int num;
    for (int i = 0; i < n; i++) {
        cin >> num;
        numbers.push(num);
    }

    for (int i = 0; i < s; i++) {
        numbers.pop();
    }

    if (numbers.empty()) {
        cout << 0 << endl;
        return 0;
    }
    
    int minNum = 999999;
    int xNum;
    int buffNum;

    while (!numbers.empty()) {
        buffNum = numbers.top(); numbers.pop();
        if (buffNum == x) {
            xNum = x;
            cout << "true" << endl;
            return 0;
        }
        if (buffNum <= minNum) {
            minNum = buffNum;
        }

    }
    cout << minNum << endl;
    
    return 0;
}

