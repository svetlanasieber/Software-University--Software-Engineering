using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestApp;

public class Sorting
{
    public static double[] ShallowAscendingSort(double[] array)
    {
        double[] resultArray = array.OrderBy(x => x).ToArray();
        return resultArray;
    }

    public static double[] DeepAscendingSort(double[] array)
    {
        Array.Sort(array);
        return array;
    }
}
