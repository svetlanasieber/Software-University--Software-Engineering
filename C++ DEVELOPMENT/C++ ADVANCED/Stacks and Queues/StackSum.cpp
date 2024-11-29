#include <iostream>
#include <sstream>
#include <string>
#include <stack>

using namespace std;

stack<int> readInput() {
	stack<int> numbers;

	string input;
	getline(cin, input);

	istringstream inputStream(input);

	int num;
	while (inputStream >> num) {
		numbers.push(num);
	}

	return numbers;
}

int main()
{

	stack<int> numbers = readInput();

	/* 
	while (!numbers.empty()) {
		cout << numbers.top() << endl;
		numbers.pop();
	}
	*/

	while (true) {
		string command;
		getline(cin, command);

		for (int i = 0; i < command.length(); i++) {
			char c = tolower(command[i]);
			command[i] = c;
		}
		
		if (command == "end")
			break;

		string operation;
		int num1;

		istringstream ss(command);
		
		ss >> operation;
		ss >> num1;

		if (operation == "add") {
			int num2;
			ss >> num2;

			numbers.push(num1); numbers.push(num2);
		}
		else if (operation == "remove") {
			if (numbers.size() <= num1)
				continue;
			for (int i = 0; i < num1; i++)
				numbers.pop();
		}

	}

	int sumNumbers = 0;
	while (!numbers.empty()) {
		sumNumbers += numbers.top();
		numbers.pop();
	}
	
	cout  << sumNumbers << endl;

	return 0;
}

