#include <iostream>
#include <iomanip>

int hexToDec(std::string const& hexStr) {
  return stoi(hexStr, nullptr, 16);
}

int main() {
  std::string colorA, colorB;
  std::cin >> colorA >> colorB;

  std::cout << "#";
  for (size_t i = 0; i < 3; i++) {
    std::cout << std::setw(2) << std::setfill('0') << std::hex
              << ((hexToDec(colorA.substr(i * 2 + 1, 2)) + hexToDec(colorB.substr(i * 2 + 1, 2))) / 2);
  }
  std::cout << std::endl;

  return 0;
}
