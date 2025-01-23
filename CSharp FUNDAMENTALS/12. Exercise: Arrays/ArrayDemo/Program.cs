 int[] numbers = new int[5];
 numbers[0] = 1;
 numbers[1] = 2;
 numbers[2] = 3;
 
 //Printing array direct -> Print type of the variable
 //Benefit -> know the index of element, reverse reading
 for (int i = 0; i < numbers.Length; i++)
 {
     int currNum = numbers[i];
     Console.WriteLine($"Index {i} -> {currNum}");
 }

 Console.WriteLine("--------------------------------------");
 //Reverse reading
 // Type 1
 //for (int i = numbers.Length - 1; i >= 0; i--)
 //{
 //    int currNum = numbers[i];
 //    Console.WriteLine($"Index {i} -> {currNum}");
 //}
 
 //2. Type 2
 for (int i = 0; i < numbers.Length; i++)
 {
     int currNum = numbers[numbers.Length - i - 1];
     Console.WriteLine($"Index {numbers.Length -i - 1} -> {currNum}");
 }
 
 Console.WriteLine("--------------------------------------");
 
 //Benefit -> Less code, easy to use, no indexes
 foreach (int num in numbers)
 {
     Console.WriteLine(num);
 }
