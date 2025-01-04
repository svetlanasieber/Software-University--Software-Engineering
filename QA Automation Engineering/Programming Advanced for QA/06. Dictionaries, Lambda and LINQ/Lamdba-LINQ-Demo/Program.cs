//lambda expression -> anonymous in-line methods
//a => a > 5

static bool isGreaterThanFive(int a)
{
    return a > 5;
}

//LINQ

string[] words = { "abc", "def" };
words.Select(w => w + "x");


int[] nums = Console.ReadLine()   //"4 5 6 1 9" 
              .Split()            //["4", "5", "6", "1", "9"]
              .Select(number => int.Parse(number))
              .ToArray();

List<double> numsList = Console.ReadLine() //"4 5 6 1 9" 
                    .Split()               //["4", "5", "6", "1", "9"]
                    .Select(double.Parse)   //[4, 5, 6, 1, 9]
                    .ToList();               //{4, 5, 6, 1, 9}


Console.WriteLine(nums.Min());
Console.WriteLine(numsList.Min());


Console.WriteLine(nums.Max());
Console.WriteLine(numsList.Max());


Console.WriteLine(nums.Average());
Console.WriteLine(numsList.Average());


Console.WriteLine(nums.Sum());
Console.WriteLine(numsList.Sum());


int[] positiveNumbersArray = Console.ReadLine()
                              .Split()
                              .Select(int.Parse)
                              .Where(n => n > 0)
                              .ToArray();






