#include <iostream>
#include <sstream>
#include <string>
#include <queue>

using namespace std;

bool canComplete(queue<int> liters, queue<int> distances) {
    int curFuel = 0;

    while (!liters.empty()) {
        int fuel = liters.front(); liters.pop();
        int dist = distances.front(); distances.pop();

        curFuel += fuel;
        if (curFuel < dist) {
            return false;
        }
        curFuel -= dist;
    }

    return true;
}

int main()
{
    int n;
    cin >> n; cin.ignore();

    queue<int> liters;
    queue<int> distances;

    for (int i = 0; i < n; i++) {
        int petrol;
        cin >> petrol;
        liters.push(petrol);

        int distance;
        cin >> distance;
        distances.push(distance);
    }

    int index = 0;
    while (!canComplete(liters, distances)) {
            int pumpLiters = liters.front(); liters.pop();
            liters.push(pumpLiters);
            int pumpDist = distances.front(); distances.pop();
            distances.push(pumpDist);
            index++;   
    }
    
    cout << index << endl;

    return 0;
}
