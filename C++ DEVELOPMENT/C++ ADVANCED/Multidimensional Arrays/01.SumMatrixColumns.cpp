#include <vector>
#include <iostream>

using namespace std;

int main()
{
    int rows, cols;
    cin >> rows >> cols;

    vector<vector<int> > matrix;
    matrix.resize(rows);

    int r, c;

    for (r = 0; r < rows; r++) {
        matrix[r].resize(cols);

        for (c = 0; c < cols; c++) {
            cin >> matrix[r][c];
        }
    }

    for (c = 0; c < cols; c++) {
        int colSum = 0;
        for (r = 0; r < rows; r++) {
            colSum += matrix[r][c];
        }

        cout << colSum << endl;
    }

    return 0;
}
