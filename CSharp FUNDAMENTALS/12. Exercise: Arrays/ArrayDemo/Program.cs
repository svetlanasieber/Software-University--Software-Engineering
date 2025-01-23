 int[] numbers = new int[5];
 numbers[0] = 1;
 numbers[1] = 2;
 numbers[2] = 3;
 

 for (int i = 0; i < numbers.Length; i++)
 {
     int currNum = numbers[i];
     Console.WriteLine($"Index {i} -> {currNum}");
 }
