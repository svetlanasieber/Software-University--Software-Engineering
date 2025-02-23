using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestApp;

public class ListManipulation
{
    public static List<int> RemoveNegativesAndReverse(List<int> list)
    {
        list.RemoveAll(x => x < 0); //премахва отрицателните числа от списъка
        list.Reverse(); //обръща списъка на обратно
        return list;
    }
}
