#include <iostream>
#include <string>

int main() {
    std::string input;
    std::getline(std::cin, input);
    int length = input.length();
    for (int i = length - 1; i >= 0; i--) {
        std::cout << input[i];
    }
    return 0;
}
