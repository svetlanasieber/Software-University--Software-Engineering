#include <iostream>

using namespace std;

void printField(size_t x, size_t y, const char* field) {
    for (size_t i = 0; i < x * y; i++) {
        cout << field[i];
        if ((i + 1) % y == 0)
            cout << endl;
    }
    /*
    for (size_t i = 0; i < x; i++) {
        for (size_t j = 0; j < y; j++) {
            cout << field[i*y + j];
        }
        cout << endl;
    }
    */
    cout << endl;
}

int hasMine(size_t x, size_t y, const char * field, size_t totalRows, size_t totalCols) {
    if (x >= totalRows || y >= totalCols)
        return 0;
    return field[x * totalCols + y] == '!' ? 1 : 0;
}

char countMines(size_t x, size_t y, const char* field, size_t totalRows, size_t totalCols) {
    char mines = '0' +
        hasMine(x - 1, y - 1, field, totalRows, totalCols) +
        hasMine(x - 1, y, field, totalRows, totalCols) +
        hasMine(x - 1, y + 1, field, totalRows, totalCols) +
        hasMine(x, y - 1, field, totalRows, totalCols) +
        hasMine(x, y, field, totalRows, totalCols) +
        hasMine(x, y + 1, field, totalRows, totalCols) +
        hasMine(x + 1, y - 1, field, totalRows, totalCols) +
        hasMine(x + 1, y, field, totalRows, totalCols) +
        hasMine(x + 1, y + 1, field, totalRows, totalCols);

    return mines;
}

int main()
{
    size_t n, m;
    cin >> n >> m;

    char* minefield = new char[n * m];

    for (size_t i = 0; i < n * m; i++) {
        cin >> minefield[i];
    }

    //printMinefield(n, m, minefield);

    char* digitfield = new char[n * m];
    for (size_t i = 0; i < n; i++) {
        for (size_t j = 0; j < m; j++) {
            digitfield[i * m + j] = countMines(i, j, minefield, n, m);
        }
    }

    printField(n, m, digitfield);

    delete[] digitfield;
    delete[] minefield;

    return 0;
}
