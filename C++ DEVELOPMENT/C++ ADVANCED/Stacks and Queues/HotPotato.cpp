#include <iostream>
#include <sstream>
#include <string>
#include <queue>

using namespace std;

int main()
{
    queue<string> circle;
    string input;
    getline(cin, input);
    istringstream ss(input);

    string kid;
    while (ss >> kid)
        circle.push(kid);

    int counts;
    cin >> counts;

    int remainging = counts;
    while (circle.size() > 1) {
        kid = circle.front();
        circle.pop(); remainging--;

        if (remainging == 0) {
            cout << "Removed " << kid << endl;
            remainging = counts;
        }
        else {
            circle.push(kid);
        }

    }

    cout << "Last is " << circle.front() << endl;

    return 0;
}
