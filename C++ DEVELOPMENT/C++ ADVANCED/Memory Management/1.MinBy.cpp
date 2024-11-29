#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>

int main() {
    std::string line;
    std::getline(std::cin, line);
    
    std::stringstream ss(line);
    std::vector<std::string> words;
    std::string word;
    
    while (ss >> word) {
        words.push_back(word);
    }
    
    int n;
    std::cin >> n;
    
    if (n == 1) {
        std::string min_word = *std::min_element(words.begin(), words.end());
        std::cout << min_word << std::endl;
    } else if (n == 2) {
        std::string shortest_word = *std::min_element(words.begin(), words.end(),
                                                      [](const std::string &a, const std::string &b) {
                                                          return a.size() < b.size();
                                                      });
        std::cout << shortest_word << std::endl;
    } else if (n == 3) {
        std::string longest_word = *std::max_element(words.begin(), words.end(),
                                                     [](const std::string &a, const std::string &b) {
                                                         return a.size() < b.size();
                                                     });
        std::cout << longest_word << std::endl;
    }
    
    return 0;
}

