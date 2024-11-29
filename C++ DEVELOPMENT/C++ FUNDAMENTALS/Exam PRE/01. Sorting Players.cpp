#include <iostream>
#include <map>

int main() {
  std::map<std::string, int> playersScore{ };

  std::string name;
  while (std::cin >> name && name != "End") {
    int victories, losses;
    std::cin >> victories >> losses;

    playersScore[name] += victories;
    playersScore[name] -= losses;
  }

  for (const auto& player : playersScore) {
    std::cout << player.first << " " << player.second << std::endl;
  }

  return 0;
}
