#include <iostream>
#include <limits.h>
using namespace std;

constexpr int MAX_N = 100;

void readArray(int arr[], const int& n)
{
    for (int i = 0; i < n; i++) cin >> arr[i];
}

int main()
{
    int arr[MAX_N];

    int n;
    cin >> n;

    readArray(arr, n);

    for (int i = 0; i < n; i++)
    {
        bool isTop = true;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] >= arr[i])
            {
                isTop = false;
                break;
            }
        }

        if (isTop) cout << arr[i] << ' ';
    }
    return 0;
}
