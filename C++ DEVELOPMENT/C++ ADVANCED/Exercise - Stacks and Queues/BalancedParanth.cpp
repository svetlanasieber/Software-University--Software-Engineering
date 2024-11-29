#include <iostream>
#include <sstream>
#include <string>
#include <stack>

using namespace std;

bool isCorrect(const string& line) {
    stack<char> parenth;

    for (int i = 0; i < line.length(); i++) {
        char c = line[i];

        switch (c)
        {
        case '(':
        case '{':
        case '[':
            parenth.push(c);
            break;

        default:
            if (parenth.empty())
                return false;
            char top = parenth.top(); parenth.pop();

            if (c == ')' && top != '(')
                return false;

            if (c == '}' && top != '{')
                return false;

            if (c == ']' && top != '[')
                return false;
            break;
        }
    }
    
    return true;
}

int main()
{
    string line;
    getline(cin, line);
    
    cout << (isCorrect(line) ? "YES" : "NO") << endl;
    
    return 0;
}

