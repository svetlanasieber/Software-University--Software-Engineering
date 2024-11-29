#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

const size_t N = 256;

int main()
{
    char* buffer = new char[N];

    cin.get(buffer, N);

    size_t len = strlen(buffer);

    size_t idx;
    for (idx = 0; idx < len; idx++)
        buffer[idx] = tolower(buffer[idx]);
    cout << buffer << endl;

    for (idx = 0; idx < len; idx++)
        buffer[idx] = toupper(buffer[idx]);
    cout << buffer << endl;

    delete[] buffer;

    return 0;
}
