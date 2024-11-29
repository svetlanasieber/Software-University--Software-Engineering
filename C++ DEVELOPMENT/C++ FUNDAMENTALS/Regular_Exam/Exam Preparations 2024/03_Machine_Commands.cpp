#include <iostream>
#include <string>
#include <list>
#include <sstream>

using namespace std;

int main() {
    string command;
    list<int> numbers;

    while (cin >> command && command != "end") {
        istringstream iss(command);
        int number;
        // Second solution => not better
//        if (command.find_first_not_of("abcdefghigklmnopqrstuvwxyz") != string::npos) {
//            numbers.push_back(stoi(command));
//        }

        if (iss >> number) {
            numbers.push_back(number);
        }
        else if (command == "sum") {
            int num1 = numbers.back();
            numbers.pop_back();

            int num2 = numbers.back();
            numbers.pop_back();

            numbers.push_back(num1 + num2);
        }
        else if (command == "subtract") {
            int num1 = numbers.back();
            numbers.pop_back();

            int num2 = numbers.back();
            numbers.pop_back();

            numbers.push_back(num1 - num2);
        }
        else if (command == "concat") {
            string num1 = to_string(numbers.back());
            numbers.pop_back();

            string num2 = to_string(numbers.back());
            numbers.pop_back();

            numbers.push_back(stoi(num2 + num1));
        }
        else if (command == "discard") {
            numbers.pop_back();
        }
    }

    for (int& num : numbers) {
        cout << num << endl;
    }

    return 0;
}
