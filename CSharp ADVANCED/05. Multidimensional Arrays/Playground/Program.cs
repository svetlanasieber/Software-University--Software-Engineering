var matrix = new int[4, 5];

string[,,] cube = new string[5, 5, 5];

matrix[1, 1] = 10;
matrix[2, 2] = 20;

Console.WriteLine(matrix[1, 1]);

var arr = new[] {1, 2, 3 };

Console.WriteLine(matrix.GetLength(0)); //Rows
Console.WriteLine(matrix.GetLength(1)); //Cols
