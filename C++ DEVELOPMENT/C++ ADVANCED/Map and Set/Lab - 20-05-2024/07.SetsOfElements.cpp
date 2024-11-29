#include <iostream>
#include <set>
#include <string>
#include <sstream>
#include <utility>
#include <algorithm>
#include <vector>

using namespace std;

void getSetAndVector(set<int>& setNums, vector<int> & ordNums, const int& count) {
    int i;
    for (i = 0; i < count; i++) {
        int num;
        cin >> num;

        auto it = find(setNums.begin(), setNums.end(), num);
        if (it == setNums.end()) {
            setNums.insert(num);
            ordNums.push_back(num);
        }
    }
}

int main()
{
    int n, m;
    cin >> n >> m;

    set<int> first;
    vector<int> orderFirst;
    getSetAndVector(first, orderFirst, n);

    set<int> second;
    vector<int> orderSecond;
    getSetAndVector(second, orderSecond, m);

    sort(orderFirst.begin(), orderFirst.end());
    sort(orderSecond.begin(), orderSecond.end());


    vector<int> newSet(1000);

    vector<int>::iterator it, ls;
    ls = set_intersection(orderFirst.begin(), orderFirst.end(), orderSecond.begin(), orderSecond.end(), newSet.begin());

    newSet.resize(ls - newSet.begin());

    for (it = newSet.begin(); it != newSet.end(); it++)
        cout << *it << " ";
    cout << endl;

    return 0;
