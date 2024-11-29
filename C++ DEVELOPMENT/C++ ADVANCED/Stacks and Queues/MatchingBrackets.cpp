#include <iostream>
#include <stack>
#include <string>
#include <vector>


int closedBrackets; // how much bracket are open/closed
int subExpressions ; // how much are inside (())
int flag ; // helps to count the subExpressions
int counter ; // count all brackets

std::vector<std::string> output;

void getExpressions( std::stack<char> original, std::stack<char> transfer , int&closedBrackets , int &subExpressions , std::string input) {

    int counter = 0;
    int flag = 0;

    int size = input.length();

    for (int i = 0; i <= size; i++) {
        char tmp = original.top();

        if (tmp == '(') {
            closedBrackets++;
            counter++;
        }
        else if (tmp == ')') closedBrackets--;

        if (tmp == '(' && flag == 0)    flag++;
        else if (tmp == '(' && flag > 0)  subExpressions++;

        if (tmp == ')' && flag > 0 && closedBrackets == 0)  flag--;

        original.pop();}}



void getSubs(std::stack<char> original, std::stack<char> transfer, std::string input , int &n) {

    std::string tmpS;

    int counter = 0;
    int flag = 0;

    int size = input.length();
    int record = 0;

    for (int i = 0; i <= size; i++) {

        char tmp = original.top();

        if (tmp == '(') counter++;
        else if (tmp == ')') counter--;


            if (tmp == '(' && counter == n) record++;

            original.pop();

            if (record > 0) tmpS.push_back(tmp);
            if (tmp == ')' && record > 0 && counter != n) {
                output.push_back(tmpS);
                tmpS = "";
                record--;
            }

    }
}


int main() {

    std::string input;
    getline(std::cin, input); // get the 1st line

    std::stack<char> transfer;
    std::stack<char> original;

    int size = input.length();

    for (int i = size; i > -1; i--) original.push(input[i]);

    getExpressions(original, transfer, closedBrackets, subExpressions, input);

    int rounds;

    if (subExpressions == 0) rounds = 1; // if there are no subExpressions then prints the brackets
    else rounds = subExpressions;

    for(int i = rounds; i >= 1; i--) getSubs(original, transfer, input , i);

    for (int i = 0; i < output.size(); i++) std::cout << output[i] << std::endl;

    return 0;
}
