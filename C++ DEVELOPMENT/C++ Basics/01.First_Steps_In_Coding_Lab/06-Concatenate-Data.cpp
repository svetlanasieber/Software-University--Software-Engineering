#include <iostream>
#include <string>

using namespace std;

int main()
{
	//1. въвеждаме: име, фамилия, възраст, град
	//2. отпечатваме: "You are <firstName> <lastName>, a <age>-years old person from <town>."

	string name;
	cin >> name;

	string lastName;
	cin >> lastName;

	int age;
	cin >> age;

	string town;
	cin >> town;

	cout << "You are " << name << " " << lastName << ", a " << age << "-years old person from " << town << ".";
}