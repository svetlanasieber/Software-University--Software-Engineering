#include <iostream>
#include <stack>
#include <queue>
#include <string>

int main() {
    std::stack<std::string> flowA;
    std::queue<std::string> flowB;
    std::string fishName, flowType;

    while (true) {
        std::cin >> fishName;
        if (fishName == "end") break;
        std::cin >> flowType;

        if (flowType == "A") {
            flowA.push(fishName);
        }
        else if (flowType == "B") {
            flowB.push(fishName);
        }
    }

    std::cout << "Flow A:" << std::endl;
    if (flowA.empty()) {
        std::cout << "<EMPTY>" << std::endl;
    }
    else {
        bool isFirst = true;
        while (!flowA.empty()) {
            if (!isFirst) {
                std::cout << ", ";
            }
            std::cout << flowA.top();
            flowA.pop();
            isFirst = false;
        }
        std::cout << std::endl;
    }

   
    std::cout << "Flow B:" << std::endl;
    if (flowB.empty()) {
        std::cout << "<EMPTY>" << std::endl;
    }
    else {
        bool isFirst = true;
        while (!flowB.empty()) {
            if (!isFirst) {
                std::cout << ", ";
            }
            std::cout << flowB.front();
            flowB.pop();
            isFirst = false;
        }
        std::cout << std::endl;
    }

    return 0;
}
