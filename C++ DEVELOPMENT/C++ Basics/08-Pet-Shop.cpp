#include <iostream>

using namespace std;

int main()
{
	//1. въвеждаме брой храна за кучета и брой храна за котки
	//2. изчисляваме обща сума = сума за кучета + сума котки
	//3. отпечатваме: "{крайната сума} lv."

	int countDogs;
	cin >> countDogs;

	int countCats;
	cin >> countCats;

	double sum = (countDogs * 2.50) + (countCats * 4);

	cout << sum << " lv.";
}