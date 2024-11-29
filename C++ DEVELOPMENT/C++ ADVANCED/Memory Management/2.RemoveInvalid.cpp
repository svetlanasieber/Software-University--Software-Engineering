#include <iostream>
#include <sstream>
#include <vector>

int main() {
    std::string line;
    std::vector<std::string> valid_companies;

    while (std::getline(std::cin, line)) {
        if (line == "end") {
            break;
        }

        std::stringstream ss(line);
        int id;
        std::string name;

        ss >> id;
        std::getline(ss, name);

        name.erase(0, name.find_first_not_of(" "));

        if (id >= 0) {
            valid_companies.push_back(std::to_string(id) + " " + name);
        }
    }

    for (const std::string& company : valid_companies) {
        std::cout << company << std::endl;
    }

    return 0;
}

