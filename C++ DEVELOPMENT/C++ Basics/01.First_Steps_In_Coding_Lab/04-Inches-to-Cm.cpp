#include <iostream>
using namespace std;

int main()
{
	//1. въвеждаме инчове
	//2. преобразуваме инчове в см
	//3. отпечатваме см

	double inches;
	cin >> inches;

	double cm = inches * 2.54;

	cout << cm << endl;

	return 0;
}