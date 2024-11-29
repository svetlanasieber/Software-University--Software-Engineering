#include <iostream>
#include <sstream>
#include <string>
#include <queue>

using namespace std;

int main()
{
    int n, s, x;
    cin >> n >> s >> x;

    queue<int> numbers;
    int i;
    int num;
    for (i = 0; i < n; i++) {
        cin >> num;
        numbers.push(num);
    }

    for (i = 0; i < s; i++) {
        numbers.pop();
    }

    if (numbers.empty()) {
        cout << 0 << endl;
        return 0;
    }

    int minNum = 999999;
    while (!numbers.empty()) {
        num = numbers.front(); numbers.pop();
        if (num <= minNum) {
            minNum = num;
        }

        if (num == x) {
            cout << "true" << endl;
            return 0;
        }
    }

    cout << minNum << endl;
    return 0;
}
