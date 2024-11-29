#include <iostream>
#include <vector>
#include <cmath>
#include <sstream>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<vector<int>> matrix(n, vector<int>(n));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> matrix[i][j];
        }
    }

    cout << "  ";
    for (int i = 0; i < n; ++i) {
        cout << char('A' + i) << " ";
    }
    cout << endl;

    for (int i = 0; i < n; ++i) {
        cout << char('A' + i) << " ";
        for (int j = 0; j < n; ++j) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }

    vector<string> opportunities;
    int totalOpportunities = 0;
    int maxOptimization = 0;
    vector<string> maxPaths;

    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            int diff = abs(matrix[i][j] - matrix[j][i]);
            if (diff > 0) {
                string path1 = char('A' + i) + string(1, char('A' + j));
                string path2 = char('A' + j) + string(1, char('A' + i));
                opportunities.push_back(path1 + "(" + to_string(matrix[i][j]) + ") - " + path2 + "(" + to_string(matrix[j][i]) + ")");
                totalOpportunities += diff;

                if (diff > maxOptimization) {
                    maxOptimization = diff;
                    maxPaths.clear();
                    maxPaths.push_back(path1 + "-" + path2);
                }
                else if (diff == maxOptimization) {
                    maxPaths.push_back(path1 + "-" + path2);
                }
            }
        }
    }

    for (const auto& opp : opportunities) {
        cout << opp << endl;
    }

    cout << "Total opportunities: " << totalOpportunities << endl;

    if (!maxPaths.empty()) {
        cout << "Max optimization: " << maxOptimization << ": ";
        for (size_t i = 0; i < maxPaths.size(); ++i) {
            if (i > 0) cout << " ";
            cout << maxPaths[i];
        }
        cout << endl;
    }
    else {
        cout << "Max optimization: none" << endl;
    }

    return 0;
}
