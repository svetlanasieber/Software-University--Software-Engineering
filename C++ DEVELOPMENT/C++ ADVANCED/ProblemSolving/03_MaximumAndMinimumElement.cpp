// 03.MaximumAndMinimumElement.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <stack>
#include <queue>
#include<climits>
using namespace std;

int maxValue(stack<int> stack)
{
	int max = INT_MIN;
	while (!stack.empty())
	{
		if (stack.top() > max)
			max = stack.top();
		stack.pop();
	}
	return max;
}

int minValue(stack<int> stack)
{
	int min = INT_MAX;
	while (!stack.empty())
	{
		if (stack.top() < min)
			min = stack.top();
		stack.pop();
	}
	return min;
}

int main()
{
	int n;
	int query;
	int element;
	stack<int> container;
	priority_queue<int> maxqueue;
	cin >> n;
	for (size_t i = 0; i < n; i++)
	{
		cin >> query;
		switch (query)
		{
		case 1:
			cin >> element;
			container.push(element);
			break;

		case 2:
			if (!container.empty())
				container.pop();
			break;
		case 3:
			if (!container.empty())
				cout << maxValue(container) << endl;
			break;
		case 4:
			if (!container.empty())
				cout << minValue(container) << endl;
			break;
		}
	}

	while (true)
	{
		cout << container.top();
		container.pop();
		if (container.empty())
		{
			cout << endl;
			break;
		}
		else
			cout << ", ";
	}
	return 0;
}
