#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    
    int numStudents, numTopStudents = 0, numBetween4_99 = 0, numBetween3_99 = 0, numFail = 0;
    double grade, totalGrade = 0.0;
    cin >> numStudents;

   
    for (int i = 0; i < numStudents; ++i) {
        cin >> grade;
        totalGrade += grade;

        
        if (grade >= 5.00)
            numTopStudents++;
        else if (grade >= 4.00)
            numBetween4_99++;
        else if (grade >= 3.00)
            numBetween3_99++;
        else
            numFail++;
    }

    
    double percentageTopStudents = (static_cast<double>(numTopStudents) / numStudents) * 100;
    double percentageBetween4_99 = (static_cast<double>(numBetween4_99) / numStudents) * 100;
    double percentageBetween3_99 = (static_cast<double>(numBetween3_99) / numStudents) * 100;
    double percentageFail = (static_cast<double>(numFail) / numStudents) * 100;
    double averageGrade = totalGrade / numStudents;

    cout << fixed << setprecision(2);
    cout << "Top students: " << percentageTopStudents << "%" << endl;
    cout << "Between 4.00 and 4.99: " << percentageBetween4_99 << "%" << endl;
    cout << "Between 3.00 and 3.99: " << percentageBetween3_99 << "%" << endl;
    cout << "Fail: " << percentageFail << "%" << endl;
    cout << "Average: " << averageGrade << endl;

    return 0;
}
