#include <iostream>
#include <map>
#include <vector>
#include <numeric>
#include <iterator>

using namespace std;

int main()
{
    int n;
    cin >> n; cin.ignore();

    map <string, vector<double> > studentsGrades;
    vector<string> names;
    string name;
    vector<double> grades;

    for (int i = 0; i < n; i++) {
        cin >> name;
        double grade;
        cin >> grade;

        if (studentsGrades.find(name) == studentsGrades.end()) {
         
            studentsGrades[name] = grades;
            names.push_back(name);
        }
        
        studentsGrades[name].push_back(grade);
    }

    
    cout.setf(ios::fixed);
    cout.precision(2);
    for (int i = 0; i < names.size(); i++) {
        name = names[i];
        grades = studentsGrades[name];
        double total = accumulate(grades.begin(), grades.end(), 0.0);
        double average = total / grades.size();
        
        cout << name << " -> ";
        for (int i = 0; i < grades.size(); i++) {
            cout << grades[i] << " ";
        }
        cout << "(avg: " << average << ")" << endl;

    }

    return 0;
}
