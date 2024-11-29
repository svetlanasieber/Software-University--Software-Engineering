#include <iostream>
#include <vector>
#include <string>
#include <iomanip>
#include <sstream>

struct Cattle {
    char type;
    int size;

    Cattle(char t, int s) : type(t), size(s) {}
};

std::ostream& operator<<(std::ostream& os, const Cattle& c) {
    return os << c.type << c.size;
}

void calculateAndPrint(const std::vector<Cattle>& cattleList, const std::string& name) {
    if (cattleList.empty()) {
        std::cout << "no " << name << "!" << std::endl;
        return;
    }

    double sum = 0;
    std::cout << cattleList.size() << " " << name << ": ";
    for (const auto& cattle : cattleList) {
        std::cout << cattle << " ";
        sum += cattle.size;
    }
    double avgSize = sum / cattleList.size();
    std::cout << "with avg. size " << std::fixed << std::setprecision(2) << avgSize << std::endl;
}

int main() {
    std::vector<Cattle> cows;
    std::vector<Cattle> sheep;
    std::vector<Cattle> others;

    std::string input;
    std::getline(std::cin, input);
    std::istringstream iss(input);
    char cattleType;
    int cattleSize;

    while (iss >> cattleType >> cattleSize) {
        if (cattleType == 'C') {
            cows.emplace_back(cattleType, cattleSize);
        }
        else if (cattleType == 'S') {
            sheep.emplace_back(cattleType, cattleSize);
        }
        else {
            others.emplace_back(cattleType, cattleSize);
        }
    }

    
    calculateAndPrint(cows, "cows");
    calculateAndPrint(sheep, "sheep");
    calculateAndPrint(others, "others");

    return 0;
}
