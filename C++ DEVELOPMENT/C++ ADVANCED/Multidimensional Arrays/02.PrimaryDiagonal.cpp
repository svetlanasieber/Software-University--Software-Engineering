#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n;
    cin >> n;

    vector < vector<int> > matrix;
    matrix.resize(n);

    int sumPrimaryDiag = 0;

    for (int r = 0; r < n; r++) {
        matrix[r].resize(n);
        for (int c = 0; c < n; c++) {
            cin >> matrix[r][c];
            if (r == c) {
                sumPrimaryDiag += matrix[r][c];
            }
        }
    }

    cout << sumPrimaryDiag << endl;

    return 0;
}
