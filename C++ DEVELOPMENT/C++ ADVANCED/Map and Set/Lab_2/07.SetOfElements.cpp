#include <map>
#include <set>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>


using namespace std;

void readSet(int count, set<int> & res) {

    while(count--) {
        int n;
        cin >> n;
        res.insert(n);
    }
}

set<int> readSet(int count) {

    set<int> res;

    while(count--) {
        int n;
        cin >> n;
        res.insert(n);
    }

    return res;
}

int main(void) {

    int n, m;
    set<int> N, M;

    cin >> n >> m;

    readSet(n, N);
    M = readSet(m);

    for(int firstSet : N) {
        if (M.find(firstSet) != M.end())
            cout << firstSet << " ";
    }

    cout << endl;

    return 0;
}
