#include <string>
#include <iostream>
#include <sstream>
#include <vector>
#include <list>
#include <map>
#include <set>
#include <algorithm>
#include <cctype>

using namespace std;

class Plate {

private:
    static const size_t DIMENSION = 10;

    static const char RUST = '!';
    static const char ALPAKA = '#';
    static const char EMPTY = '.';
    static const char TEMP_RUST = '?';

    char matrix[DIMENSION][DIMENSION];

    void setRust(int row, int col, char symbol) {

        if (row < 0 || col < 0 || row >= DIMENSION || col >= DIMENSION)
            return;
        
        if (matrix[row][col] == EMPTY)    
            matrix[row][col] = symbol;
    }

    void putTempRust() {

        for(int row = 0; row < DIMENSION; row++)
            for(int col = 0; col < DIMENSION; col++) 
                if (matrix[row][col] == RUST)
                {
                    setRust(row-1, col, TEMP_RUST);
                    setRust(row+1, col, TEMP_RUST);
                    setRust(row, col-1, TEMP_RUST);
                    setRust(row, col+1, TEMP_RUST);
                }

    }

    void fixTempRust() {

        for(int row = 0; row < DIMENSION; row++)
            for(int col = 0; col < DIMENSION; col++) 
                if (matrix[row][col] == TEMP_RUST)
                    matrix[row][col] = RUST;

    }

public:

    Plate(istream & istr) {
        for(size_t row = 0; row < DIMENSION; row++)
            for(size_t col = 0; col < DIMENSION; col++)
                istr >> matrix[row][col];
    }

    void print(ostream & ostr) {

        for(size_t row = 0; row < DIMENSION; row++) {
            for(int col = 0; col < DIMENSION; col++)
                ostr << matrix[row][col]; 
            ostr << endl;
        }
    }

    // does one tick of rust
    void rust() {

        putTempRust();
        //cout << "----" << endl << "Tick: " << ticks << ", applied temp rust." << endl;
        //printMatrix(matrix);
        fixTempRust();
        //cout << "----" << endl << "Tick: " << ticks << ", fixed temp rust." << endl;
        //printMatrix(matrix);

    }
};


class RustProcessor {

    Plate plate;
    size_t ticks;

    public:

        RustProcessor(istream & istr) 
            : plate(istr),
              ticks(0) {
            istr >> ticks;
        }

        void process() {

            size_t ticks = this->ticks;

            for(;ticks;ticks--)
                plate.rust();
        }

        void print(ostream & ostr) {
            plate.print(ostr);
        }
};


int main() {

    RustProcessor rp(cin);

    rp.process();

    rp.print(cout);

    return 0;
}
