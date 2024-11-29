#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int task2() {
    int countProducts;
    cin >> countProducts;

    vector<string> products;

    for (int i = 0; i < countProducts; i++) {
        string product;
        cin >> product;

        products.push_back(product);
    }

    sort(products.begin(), products.end());

    for (size_t i = 1; i <= products.size(); i++) {
        cout << i << '.' << products[i - 1] << endl;
    }

    return 0;
}
