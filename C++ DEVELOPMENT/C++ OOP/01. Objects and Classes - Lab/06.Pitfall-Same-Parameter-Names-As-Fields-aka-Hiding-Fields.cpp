#include<iostream>
#include<string>
using namespace std;

class Person {
    public:
    string name;
    int age = 0;
    double heightMeters = 0;

    Person(string name, int age, double heightMeters) {
        name = name;
        age = age;
        heightMeters = heightMeters;
    }

};

void printPersonInfo(Person person) {
    cout << "name: " << person.name << ", age: " << person.age
        << ", height: " << person.heightMeters
        << endl;
}

int main() {
    printPersonInfo(Person("Ary O'usure", 42, 1.3));

    return 0;
}
