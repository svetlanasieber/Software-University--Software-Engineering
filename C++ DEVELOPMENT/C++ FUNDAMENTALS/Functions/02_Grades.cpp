#include <iostream>

using namespace std;

void printGradeInText(float grade) {
    if (grade < 3) {
        cout << "Fail";
    }
    else if (grade < 3.50) {
        cout << "Poor";
    }
    else if (grade < 4.50) {
        cout << "Good";
    }
    else if (grade < 5.50) {
        cout << "Very good";
    }
    else {
        cout << "Excellent";
    }
}

int main() {
    float grade;
    cin >> grade;

    printGradeInText(grade);

    return 0;
}