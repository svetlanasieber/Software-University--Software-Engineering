#include<iostream>
#include<string>
using namespace std;

class Person {
    class Body {
        public:
        double heightMeters;
        double weightKgs;
    };


    public:
    string name;
    int age;

    Body body;
};


void printPersonInfo(Person person) {
    cout << "name: " << person.name << ", age: " << person.age
        << ", height: " << person.body.heightMeters << ", weight: " << person.body.weightKgs
        << endl;
}

void makePersonOlder(Person& person, int years) {
    person.age += years;
}

int main() {
    Person person;
   
    cout << "person (not initialized) = ";
    printPersonInfo(person);

  
    person.name = "Lorem";
    person.age = 42;
    person.body.heightMeters = 1.3;
    person.body.weightKgs = 69;

    Person people[3];
    people[0] = person;

    cout << "people[0] = ";
    printPersonInfo(people[0]);

    makePersonOlder(people[0], 1);
    cout << "people[0] (after aging) = ";
    printPersonInfo(people[0]);

    Person * newPerson = new Person();
    newPerson->name = "Ipsum";
    newPerson->age = 4;
    newPerson->body.heightMeters = 0.4;
    newPerson->body.weightKgs = 4.5;

    cout << "newPerson = ";
    printPersonInfo(*newPerson);
    delete newPerson;

    return 0;
}
