#include<iostream>

int main() {
	using namespace std;

	int number = 42;
	int* ptr = &number;

	*ptr++;
	cout << *ptr << endl;
	return 0;
}
