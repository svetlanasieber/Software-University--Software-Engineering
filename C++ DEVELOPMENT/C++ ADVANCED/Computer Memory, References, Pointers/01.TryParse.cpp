#include <iostream>
#include <cctype>

using namespace std;

bool tryParse(const char * data, int & number) {
    int ret = 0;
    while(*data != '\0') {
        if (isdigit(*data)) {
            ret *= 10; 
            ret += (*data - '0'); // '1' - '0' ==> 1
        } else
            return false; // it's not a number!
        
        data++;
    }

    number = ret;
    return true;
}

int main(void) {

    string str1, str2;
    cin >> str1 >> str2;

    bool ok1, ok2;
    int int1, int2;

    ok1 = tryParse(str1.c_str(), int1);
    ok2 = tryParse(str2.c_str(), int2);

    if (ok1 && ok2)
        cout << int1 + int2 << endl;
    else {
        if (ok1)
            cout << int1 << endl;
        else
            cout << "[error] " << str1 << endl;

        if (ok2)
            cout << int2 << endl;
        else
            cout << "[error] " << str2 << endl;
    }

    return 0;
}
