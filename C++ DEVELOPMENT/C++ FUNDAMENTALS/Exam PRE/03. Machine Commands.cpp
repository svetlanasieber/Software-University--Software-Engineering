#include <iostream>
#include <utility>
#include <vector>
#include <iterator>

class Machine {
  std::vector<int> numbers{ };
public:
  void sum() {
    const int first = numbers.back();
    numbers.pop_back();
    const int second = numbers.back();
    numbers.pop_back();

    const int sum = first + second;

    numbers.emplace_back(sum);
  }

  void subtract() {
    const int minuend = numbers.back();
    numbers.pop_back();
    const int subtrahend = numbers.back();
    numbers.pop_back();

    const int difference = minuend - subtrahend;

    numbers.emplace_back(difference);
  }

  void concat() {
    const int second = numbers.back();
    numbers.pop_back();
    const int first = numbers.back();
    numbers.pop_back();

    const std::string concatStr = std::to_string(first) + std::to_string(second);

    numbers.emplace_back(std::stoi(concatStr));
  }

  void discard() {
    numbers.pop_back();
  }

  void push(int num) {
    numbers.emplace_back(num);
  }

  void print(std::ostream& os) {
    std::copy(numbers.begin(), numbers.end(),
              std::ostream_iterator<int>(os, "\n"));
  }
};

class CommandProcessor {
  Machine machine;
  std::istream& is;
  std::ostream& os;
public:
  CommandProcessor(Machine machine, std::istream& is, std::ostream& os) :
      machine(std::move(machine)), is(is), os(os) { }

  void run() {
    std::string command;
    while (std::getline(is, command)) {
      if (command == "end") {
        machine.print(os);
        break;
      } else if (command == "sum") {
        machine.sum();
      } else if (command == "subtract") {
        machine.subtract();
      } else if (command == "concat") {
        machine.concat();
      } else if (command == "discard") {
        machine.discard();
      } else {
        machine.push(std::stoi(command));
      }
    }
  }
};

int main() {
  CommandProcessor({ }, std::cin, std::cout).run();

  return 0;
}
