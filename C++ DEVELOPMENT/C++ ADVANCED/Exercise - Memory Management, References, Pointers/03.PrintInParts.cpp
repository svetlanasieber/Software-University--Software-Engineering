#include <array>
#include <iostream>

using namespace std;

int main()
{
    int rows, cols;
    cin >> rows >> cols;

    int * array;
    array = new int[rows * cols];

    for (int count = 0; count < rows * cols; count++)
        cin >> array[count];

    int outRows, outCols;
    cin >> outRows >> outCols;

    for (int curRow = 0; curRow < outRows; curRow++) {
        for (int curCol = 0; curCol < outCols; curCol++) {
            cout << array[curRow*cols + curCol] << " ";
        }
        cout << endl;
    }

    delete[] array;

    return 0;
}
