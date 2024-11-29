#include <iostream>
#include <algorithm>
#include <unordered_set>

bool isMagical(const char ch) {
  static const std::unordered_set<char> magicalItems{ 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' };
  return magicalItems.find(ch) != magicalItems.end();
}

int main() {
  std::string str;
  std::getline(std::cin, str);

  char last = '\0';
  const auto& newEnd = std::remove_if(
      str.begin(), str.end(), [&last](char current) {
        bool remove = current == last && !isMagical(current);
        last = current;
        return remove;
      });

  str.erase(newEnd, str.end());

  std::cout << str << std::endl;

  return 0;
}
