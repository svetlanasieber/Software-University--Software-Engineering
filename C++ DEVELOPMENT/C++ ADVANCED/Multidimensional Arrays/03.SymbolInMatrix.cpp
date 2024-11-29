#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n;
    cin >> n;

    vector < vector<char> > matrix;
    matrix.resize(n);

    int r, c;
    for (r = 0; r < n; r++) {
        matrix[r].resize(n);
        for (c = 0; c < n; c++) {
            cin >> matrix[r][c];
        }
    }

    char charSearched;
    cin >> charSearched;

    for (r = 0; r < n; r++) {
        for (c = 0; c < n; c++) {
            if (matrix[r][c] == charSearched) {
                cout << "(" << r << ", " << c << ")" << endl;
                return 0;
            }
        }
       
    }

    cout << charSearched << " does not occur in the matrix" << endl;

    return 0;
}
