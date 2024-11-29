#include <iostream>
#include <sstream>
 
int main() {
  int64_t curr{ };
  int64_t prev{ };
 
  std::string line;
  std::getline(std::cin >> std::ws, line);
  std::istringstream is(line);
 
  for (std::string input; is >> std::ws >> input && !input.empty();) {
    int64_t newValue;
 
    switch (input[0]) {
    case '+':
      newValue = prev + curr;
      break;
    case '*':
      newValue = prev * curr;
      break;
    case '-':
      newValue = prev - curr;
      break;
    case '/':
      newValue = prev / curr;
      break;
    default:
      newValue = stoll(input);
      break;
    }
 
    prev = curr;
    curr = newValue;
  }
 
  std::cout << curr << ' ' << prev << '\n';
 
  return 0;
}
