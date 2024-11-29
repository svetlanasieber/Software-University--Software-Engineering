#include <iostream>
#include <vector>

void printZeroIndices(const std::vector<int>& numbers) {
    for (int i = 0; i < numbers.size(); i++) {
        if (numbers[i] == 0) {
            std::cout << i << " ";
        }
    }
}

int main() {
    using namespace std;

    vector<int> numbers{ 1, 0, -2, 7, 0, 10, -100, 42 };
    return 0;
}
