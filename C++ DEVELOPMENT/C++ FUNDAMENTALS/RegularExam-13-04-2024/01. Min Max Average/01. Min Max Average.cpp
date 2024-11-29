#include <iostream>
#include <vector>
#include <iomanip>
#include <climits>

int main() {
    int N;
    std::cin >> N;
    
    std::vector<int> numbers(N);
    
    for(int i = 0; i < N; ++i) {
        std::cin >> numbers[i];
    }
    
    double sum = 0;
    int maxOdd = INT_MIN;
    int minEven = INT_MAX;
    
    for(int i = 0; i < N; ++i) {
        if(i % 2 == 0) { // even position
            if(numbers[i] < minEven) {
                minEven = numbers[i];
            }
        } else { // odd position
            if(numbers[i] > maxOdd) {
                maxOdd = numbers[i];
            }
        }
        sum += numbers[i];
    }
    
    double average = sum / N;
    
    std::cout << std::fixed << std::setprecision(2);
    std::cout << maxOdd << ".00 " << minEven << ".00 " << average << std::endl;
    
    for(int i = N - 1; i >= 0; --i) {
        std::cout << numbers[i] << " ";
    }
    std::cout << std::endl;
    
    return 0;
}
