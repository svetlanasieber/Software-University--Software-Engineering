#include <iostream>
using namespace std;

int main()
{

	double yardSize;
	cin >> yardSize;

	double totalPrice = yardSize * 7.61;
	double discount = totalPrice * 0.18;

	totalPrice = totalPrice - discount;

	cout << "The final price is: " << totalPrice << " lv." << endl;
	cout << "The discount is: " << discount << " lv." << endl;

	return 0;
}