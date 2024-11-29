#include <iostream>

using namespace std;

int main() {
    string daysOfTheWeek[] = {
            "Monday", // 0
            "Tuesday", // 1
            "Wednesday", // 2
            "Thursday", // 3
            "Friday", // 4
            "Saturday", // 5
            "Sunday"  // 6
    };

    int dayOfTheWeek;
    cin >> dayOfTheWeek;

    if (dayOfTheWeek < 1 || dayOfTheWeek > 7) {
        cout << "Invalid day!" << endl;
    }
    else {
        cout << daysOfTheWeek[dayOfTheWeek - 1] << endl;
    }

    return 0;
}