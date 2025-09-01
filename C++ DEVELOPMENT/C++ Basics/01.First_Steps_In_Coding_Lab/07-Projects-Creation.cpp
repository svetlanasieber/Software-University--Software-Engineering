#include <iostream>
#include <string>
using namespace std;

int main() 
{

	//1. въвеждаме име на архитект и брой проекти
	//2. изчисляваме време за изпълнение
	//3. отпечатваме: "The architect {името на архитекта} will need {необходими часове} hours to complete {брой на проектите} project/s."

	string architectName;
	cin >> architectName;

	int countProjects;
	cin >> countProjects;

	int time = countProjects * 3;

	cout << "The architect " << architectName << " will need " << time << " hours to complete " << countProjects << " project/s.";
}