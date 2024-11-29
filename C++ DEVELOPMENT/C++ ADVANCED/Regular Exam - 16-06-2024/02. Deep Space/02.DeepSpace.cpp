#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <cctype>
#include <algorithm> 

int main() {
    std::vector<std::string> matrix;
    std::string line;
    std::map<char, int> starCounts;
    const std::string stars = "OBAFGKMLTY";
    int totalPlanets = 0;
    int asteroidsComets = 0;

    
    while (std::getline(std::cin, line) && line != "end") {
        matrix.push_back(line);
    }

    std::string replacementChars;
    std::cin >> replacementChars;

   
    for (const auto& row : matrix) {
        for (char element : row) {
            if (stars.find(element) != std::string::npos) {
                starCounts[element]++;
            }
            else if (isdigit(element)) {
                totalPlanets += element - '0'; 
            }
            else if (element == '#' || element == '$') {
                asteroidsComets++;
            }
        }
    }

    for (auto& row : matrix) {
        for (char& ch : row) {
            if (replacementChars.find(ch) != std::string::npos) {
                ch = '+';
            }
        }
    }

    int totalStars = 0;
    for (const auto& p : starCounts) {
        totalStars += p.second;
    }

    if (totalStars > 0) {
        std::cout << "Stars: " << totalStars << std::endl;
        std::vector<char> sortedStars;
        for (const auto& p : starCounts) {
            sortedStars.push_back(p.first);
        }
        std::sort(sortedStars.begin(), sortedStars.end());
        for (char starType : sortedStars) {
            std::cout << "- " << starType << ": " << starCounts[starType] << std::endl;
        }
    }

    if (totalPlanets > 0) {
        std::cout << "Planets: " << totalPlanets << std::endl;
    }

    if (asteroidsComets > 0) {
        std::cout << "Asteroids/comets: " << asteroidsComets << std::endl;
    }

    
    for (const auto& row : matrix) {
        std::cout << row << std::endl;
    }

    return 0;
}
