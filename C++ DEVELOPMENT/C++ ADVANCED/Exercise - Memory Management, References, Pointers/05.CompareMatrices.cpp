#include <iostream>
#include <sstream>
#include <string>

using namespace std;

void readMatrix(int**& matrix, size_t& rows, size_t& cols) {
    cin >> rows; cin.ignore();

    matrix = new int* [10];

    for (size_t curRow = 0; curRow < rows; curRow++) {
        matrix[curRow] = new int[10];

        string strRow;
        getline(cin, strRow);
        istringstream ss(strRow);

        cols = 0;
        while (ss >> matrix[curRow][cols])
            cols++;
    }
}

void deleteMatrix(int** matrix) {
    for (int i = 0; i < 10; i++) {
        delete[] matrix[i];
    }
    delete[] matrix;
}

bool compareMatrices(int** mat1, size_t mat1rows, size_t mat1cols,
    int** mat2, size_t mat2rows, size_t mat2cols) {

    if ((mat1rows != mat2rows) || (mat1cols != mat2cols))
        return false;

    for (int i = 0; i < mat1rows; i++) {
        for (int j = 0; j < mat1cols; j++) {
            if (mat1[i][j] != mat2[i][j])
                return false;
        }
    }

    return true;
}

int main()
{
    size_t mat1rows, mat1cols;
    int** matrix1;
    readMatrix(matrix1, mat1rows, mat1cols);

    size_t mat2rows, mat2cols;
    int** matrix2;
    readMatrix(matrix2, mat2rows, mat2cols);

    cout << (compareMatrices(matrix1, mat1rows, mat1cols, matrix2, mat2rows, mat2cols) ? "equal" : "not equal")
        << endl;

    deleteMatrix(matrix1);
    deleteMatrix(matrix2);

    return 0;
}
