#include<iostream>

using namespace std;

int main()
{
    int number;
    int firstNumbre;
    int secondNumber;
    int thirdNumber;
    int result;

    cin >> number;

    result = 0;

    firstNumbre = number % 10;
    secondNumber = number / 10;
    secondNumber %= 10;
    thirdNumber = number / 100;
    thirdNumber %= 10;

    for (int i = 1; i <= firstNumbre; i++)
    {
        for (int j = 1; j <= secondNumber; j++)
        {
            for (int k = 1; k <= thirdNumber; k++)
            {
                result = i * j * k;

                cout << i << " * " << j << " * " << k << " = " << result << ";" << endl;
            }
        }
    }
}