#include <iostream>
#include <iomanip>

using namespace std;

int task1() {
    string name;
    cin >> name;

    int age;
    cin >> age;

    float averageGrade;
    cin >> averageGrade;

    cout.precision(2);

    cout
        << "Name: " << name << ", Age: " << age
        << ", Grade: " << fixed << averageGrade
    << endl;

    return 0;
}