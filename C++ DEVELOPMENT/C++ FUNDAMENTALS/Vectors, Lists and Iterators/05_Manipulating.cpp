#include <iostream>
#include <list>
#include <sstream>
#include <string>

using namespace std;

void removeAt(list<int>& nums, int idx) {
    list<int>::iterator it = nums.begin();
    advance(it, idx);
    nums.erase(it);
}

void insert(list<int>& nums, int num, int idx) {
    list<int>::iterator it = nums.begin();
    advance(it, idx);
    nums.insert(it, num);
}

int main() {
    list<int> numbers;

    string line;
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) numbers.push_back(num);

    while (true) {
        getline(cin, line); // "Add 3"

        if (line == "end") break;

        iss.clear(); // ""
        iss.str(line); // "Add 3"

        string command;
        iss >> command;  // Add

        if (command == "Add") {
            iss >> num; // 3
            numbers.push_back(num);
        }
        else if (command == "Remove") {
            iss >> num;
            numbers.remove(num); // removes all nums that are the same as the searched
        }
        else if (command == "RemoveAt") {
            int idx;
            iss >> idx;

            removeAt(numbers, idx);
        }
        else if (command == "Insert") {
            int idx;
            iss >> num >> idx;

            insert(numbers, num, idx);
        }
    }

    for (int& num : numbers) {
        cout << num << " ";
    }

    return 0;
}