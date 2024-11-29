#include <iostream>
#include <string>
#include <map>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int n;
	cin >> n; cin.ignore();

	map<int, int> numbers;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;

		numbers[num]++;
	}

	for (pair<int, int>el : numbers) {
		if (el.second % 2 == 0)
			cout << el.first << endl;
	}

	return 0;
}
