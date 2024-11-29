#include <iostream>
#include <sstream>
#include <string>
#include <stack>

using namespace std;

int main()
{
    string clothesStr;
    getline(cin, clothesStr);

    int capacity;
    cin >> capacity;

    stack<int> box;
    istringstream ss(clothesStr);
    int piece;

    while (ss >> piece) {
        box.push(piece);
    }

    int racksCount = 1;
    int capacityLeft = capacity;
    while (!box.empty()) {
        int current = box.top(); box.pop();
        if (current > capacityLeft) {
            racksCount++;
            capacityLeft = capacity;
        }
        
        capacityLeft -= current;

    }

    cout << racksCount << endl;

    return 0;
}

/*
8 7 4 5 9 7 8 2 5 4 7
9
*/

