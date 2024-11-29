#include <iostream>
#include <sstream>
#include <string>
#include <queue>

using namespace std;

int main()
{
    queue<string> customers;
    while (true) {
        string cust;
        cin >> cust;

        if (cust == "End")
            break;

        if (cust == "Paid") {
            while (!customers.empty()) {
                cout << customers.front() << endl;
                customers.pop();
            }
        }
        else {
            customers.push(cust);
        }
    }

    cout << customers.size() << " people remaining." << endl;

    return 0;
}

