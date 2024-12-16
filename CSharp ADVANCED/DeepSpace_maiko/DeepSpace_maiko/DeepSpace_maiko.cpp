// 02 Deep Space.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <climits>
#include <iostream>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <map>
#include <vector>

/// <summary>
/// myString наследява класа string 
/// и добавя функционалности
/// </summary>
class myString :public std::string
{
private:
    const std::string EMPTY = "";
    const std::string NEW_LINE = "\r\n";

public:
    /// <summary>
    /// празев конструктор
    /// </summary>
    myString() :std::string()
    {

    }

    /// <summary>
    /// конструктор копие
    /// </summary>
    /// <param name="str"></param>
    myString(const std::string& str) :std::string(str)
    {

    }

    myString(const std::string& str, size_t pos, size_t len = npos) :std::string(str, pos, len)
    {

    }

    myString(const char* s) :std::string(s)
    {

    }

    myString(const char* s, size_t n) :std::string(s, n)
    {

    }

    myString(size_t n, char c) :std::string(n, c)
    {

    }

    template <class InputIterator>  myString(InputIterator first, InputIterator last) : std::string(first, last)
    {

    }

    myString(std::initializer_list<char> il) :std::string(il)
    {

    }

    myString(std::string&& str) noexcept :std::string(str)
    {

    }

    /// <summary>
    /// метод връщащ празен стринг
    /// </summary>
    /// <returns></returns>
    static std::string Empty()
    {
        return "";
    }

    /// <summary>
    /// метод връщащ нов ред
    /// </summary>
    /// <returns></returns>
    static std::string NewLine()
    {
        return "\r\n";
    }

    std::string Join(std::string separator, std::set<int, std::greater<int>>* s)
    {
        std::string result = std::string();
        bool isFirst = true;

        for (std::set<int, std::greater<int>>::iterator it = s->begin(); it != s->end(); it++)
        {
            std::string s = std::to_string(*it);

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(s);
        }

        return result;
    }

    std::string Join(std::string separator, std::set<double, std::greater<double>>* s)
    {
        std::string result = std::string();
        bool isFirst = true;

        for (std::set<double, std::greater<double>>::iterator it = s->begin(); it != s->end(); it++)
        {
            std::string s = std::to_string(*it);

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(s);
        }

        return result;
    }

    static std::string Join(std::string separator, std::set<int>* s)
    {
        std::string result = std::string();
        bool isFirst = true;

        for (std::set<int>::iterator it = s->begin(); it != s->end(); it++)
        {
            std::string s = std::to_string(*it);

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(s);
        }

        return result;
    }

    std::string Join(std::string separator, std::set<std::string>* s)
    {
        std::string result = std::string();
        bool isFirst = true;

        for (std::set<std::string>::iterator it = s->begin(); it != s->end(); it++)
        {
            std::string s = (*it);

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(s);
        }

        return result;
    }

    std::string Join(std::string separator, std::vector<double>* v)
    {
        std::string result = std::string();
        bool isFirst = true;

        for (std::vector<double>::iterator it = v->begin(); it != v->end(); it++)
        {
            std::string s = std::to_string(*it);

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(s);
        }

        return result;
    }

    std::string Join(std::string separator, std::vector<int>* v)
    {
        std::string result = std::string();
        bool isFirst = true;

        for (std::vector<int>::iterator it = v->begin(); it != v->end(); it++)
        {
            std::string s = std::to_string(*it);

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(s);
        }

        return result;
    }

    static std::string Join(std::string separator, std::vector<std::string>* v)
    {
        std::string result = std::string();
        bool isFirst = true;

        for (std::vector<std::string>::iterator it = v->begin(); it != v->end(); it++)
        {
            std::string s = *it;

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(s);
        }

        return result;
    }

    static std::string Join(std::string separator, const std::queue<std::string>& q)
    {
        std::string result = std::string();

        std::queue<std::string> temp = std::queue<std::string>(q);

        bool isFirst = true;

        while (!temp.empty())
        {
            std::string currentNum = temp.front();
            temp.pop();

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(currentNum);
        }

        return result;
    }

    static std::string Join(std::string separator, const std::stack<std::string>& st)
    {
        std::string result = std::string();

        std::stack<std::string> temp = std::stack<std::string>(st);

        bool isFirst = true;

        while (!temp.empty())
        {
            std::string currentNum = temp.top();
            temp.pop();

            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                result.append(separator);
            }

            result.append(currentNum);
        }

        return result;
    }

    /// <summary>
    /// метод връщащ опашка от елементите на 
    /// текущата инстанция на myString
    /// </summary>
    /// <typeparam name="T">тип на елементите</typeparam>
    /// <returns></returns>
    template <class T>
    std::queue<T> ConvertStringToQueue()
    {
        std::stringstream iss(*this);

        T s;

        std::queue<T> result = std::queue<T>();
        while (iss >> s)
        {
            result.push(s);
        }

        return result;
    }

    /// <summary>
    /// метод връщащ стек от елементите на 
    /// текущата инстанция на myString
    /// </summary>
    /// <typeparam name="T">тип на елементите</typeparam>
    /// <returns></returns>
    template <class T>
    std::stack<T> ConvertStringToStack()
    {
        std::stringstream iss(*this);

        T number;

        std::stack<T> result = std::stack<T>();
        while (iss >> number)
        {
            result.push(number);
        }

        return result;
    }

    /// <summary>
    /// 
    /// </summary>
    /// <param name="num"></param>
    /// <returns></returns>
    template <class T>
    std::vector<T>& ConvertStringToVector(std::vector<T>& v)
    {
        std::stringstream iss(*this);

        T number;
        while (iss >> number)
        {
            v.push_back(number);
        }

        return v;
    }

    template <class T>
    std::vector<T> ConvertStringToVector()
    {
        std::vector<T> result = std::vector<T>();

        std::stringstream iss(*this);

        T number;
        while (iss >> number)
        {
            result.push_back(number);
        }

        return result;
    }

    bool TryParseInt(int& num)
    {
        try
        {
            num = stoi(*this);
        }
        catch (...)
        {
            return false;
        }

        return true;
    }

    bool TryParseDouble(double& num)
    {
        try
        {
            num = stod(*this);
        }
        catch (...)
        {
            return false;
        }

        return true;
    }

    std::vector<std::string> Split(char ch)
    {
        std::vector<std::string> result;
        std::string s = this->EMPTY;

        std::stringstream ss(*this);

        while (getline(ss, s, ch))
        {
            result.push_back(s);
        }

        return result;
    }

    std::vector<std::string> Split(std::string separator)
    {
        const std::string REPLACE_STRING_SEPARATOR = "\n";
        const char REPLACE_CHAR_SEPARATOR = REPLACE_STRING_SEPARATOR[0];

        std::vector<std::string> result;
        std::string s = std::string(*this);

        int idx = s.find(separator);

        while (idx > -1)
        {
            s.replace(idx, separator.length(), REPLACE_STRING_SEPARATOR);
            idx = s.find(separator);
        }

        std::stringstream ss(s);

        while (getline(ss, s, REPLACE_CHAR_SEPARATOR))
        {
            result.push_back(s);
        }

        return result;
    }

    bool Contains(std::string f)
    {
        int idx = this->find(f);
        return idx > -1;
    }

    bool Contains(char ch)
    {
        std::string s = std::string(1, ch);
        return this->Contains(s);
    }

    std::string ToLower()
    {
        myString s = "";

        std::string::iterator it;
        for (it = this->begin(); it != this->end(); it++)
        {
            s.append(1, tolower(*it));
        }

        return s;
    }

    std::string ToUpper()
    {
        std::string s = std::string("");

        std::string::iterator it;
        for (it = this->begin(); it != this->end(); it++)
        {
            s.append(1, toupper(*it));
        }

        return s;
    }

    ~myString()
    {

    }
};

int main()
{
    myString STAR_CLASES = "OBAFGKMLTY";
    myString PLANET_CLASES = "123456789";
    const std::string END = "end";
    const char ASTEROIDES_CLASES = '#';
    const char COMETS_CLASES = '$';
    const char REPLACE_SYMBOL = '+';

    myString input;
    std::map<char, int> stars = std::map<char, int>();

    int planetsCount = 0;
    int asteroidCount = 0;
    int cometCount = 0;

    std::string galahi = std::string();
    bool isLoopExit = false;

    std::getline(std::cin, input);
    galahi.append(input);

    int col = input.length();
    int row = 1;

    while (!isLoopExit)
    {
        std::getline(std::cin, input);

        if (input == END)
        {
            isLoopExit = true;
        }
        else
        {
            row++;
            galahi.append(input);
        }
    }

    std::getline(std::cin, input);

    for (auto world : galahi)
    {
        if (STAR_CLASES.Contains(world))
        {
            if (!stars.count(world))
            {
                stars[world] = 0;
            }

            stars[world]++;
        }

        if (PLANET_CLASES.Contains(world))
        {
            planetsCount += stoi(std::string(1, world));
        }

        if (world == ASTEROIDES_CLASES)
        {
            asteroidCount++;
        }

        if (world == COMETS_CLASES)
        {
            cometCount++;
        }
    }

    if (input.length() > 0)
    {
        for (auto ch : input)
        {
            std::string s = std::string().append(1, REPLACE_SYMBOL);
            int idx = galahi.find(ch);

            while (idx > -1)
            {
                galahi[idx] = REPLACE_SYMBOL;
                idx = galahi.find(ch);
            }
        }
    }

    std::string output = std::string();
    std::string output1 = std::string();
    int starZize = 0;

    if (stars.size() > 0)
    {
        for (auto it = stars.begin(); it != stars.end(); it++)
        {
            starZize += it->second;
            output1.append("- ").append(std::string(1, it->first)).append(": ").append(std::to_string(it->second)).append("\r\n");
        }
    }

    output.append("Stars: ").append(std::to_string(starZize)).append("\r\n");
    if (stars.size() > 0)
    {
        output.append(output1);
    }

    output.append("Planets: ").append(std::to_string(planetsCount)).append("\r\n");

    output.append("Asteroids/comets: ").append(std::to_string(asteroidCount + cometCount)).append("\r\n");

    for (size_t r = 0; r < row; r++)
    {
        for (size_t c = 0; c < col; c++)
        {
            int i = r * col + c;
            output.append(1, galahi[i]);
        }

        output.append("\r\n");
    }

    std::cout << output;
}