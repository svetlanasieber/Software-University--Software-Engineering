#include <iostream>
#include <sstream>
#include <string>
#include <queue>

using namespace std;

int findBiggest(queue<int> numbers) {
    int biggest = 0;

    while (!numbers.empty()) {
        int current = numbers.front(); numbers.pop();
        if (current >= biggest) {
            biggest = current;
        }
    }

    return biggest;
}

int main()
{
    int foodQuantity;
    cin >> foodQuantity;
    cin.ignore();

    queue<int> orders;
    string ordersStr;
    getline(cin, ordersStr);

    istringstream ss(ordersStr);
    int order;

    while (ss >> order) {
        orders.push(order);
    }

    int biggestOrder = findBiggest(orders);
    int currentOrder;

    while (!orders.empty()) {
        currentOrder = orders.front();

        if (currentOrder <= foodQuantity) {
            foodQuantity -= currentOrder;
            orders.pop();
        }
        else
            break;
        
    }

    cout << biggestOrder << endl;
    if (orders.empty()) {
        cout << "Orders complete" << endl;
    }
    else {
        cout << "Orders left: ";
        while (!orders.empty()) {
            cout << orders.front() << " ";
            orders.pop();
        }
             
        cout << endl;
    }

    return 0;
}

