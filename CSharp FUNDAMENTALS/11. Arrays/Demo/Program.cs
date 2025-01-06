int[] numbersArray = new int[6];
Console.WriteLine(numbersArray.Length); 


numbersArray[0] = 11;
numbersArray[1] = 22;
numbersArray[2] = 33;
numbersArray[3] = 88;
numbersArray[5] = 99;






Console.WriteLine(numbersArray[0]);
Console.WriteLine(numbersArray[3]);


int indexToSearch = 6;
bool inArray = indexToSearch >= 0 && indexToSearch < numbersArray.Length - 1; //numbersArray.Length;
Console.WriteLine(numbersArray[indexToSearch]);

string[] stringArray = new string[3];

float[] floatArray = new float[8];
