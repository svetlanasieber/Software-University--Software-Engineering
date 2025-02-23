using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestApp;

public class ListAnalyzer
{
    public static string Analyze(List<int> nums)
    {
        if (nums.Count == 0) //празен списък
        {
            return "No elements!";
        }

        return $"Element count: {nums.Count}, Min value: {nums.Min()}, Max value: {nums.Max()}, Avg: {nums.Average():F2}.";
    }
}

