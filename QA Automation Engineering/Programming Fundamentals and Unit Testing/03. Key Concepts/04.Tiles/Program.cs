double bathWidth = double.Parse(Console.ReadLine()); 
double bathHeigth = double.Parse(Console.ReadLine()); 
double tileWidth = double.Parse(Console.ReadLine());
double tileHeigth = double.Parse(Console.ReadLine());


double bathArea = bathWidth * bathHeigth;

bathArea = bathArea + 0.10 * bathArea;

double tileArea = tileWidth * tileHeigth;
double countTiles = bathArea / tileArea;


Console.WriteLine(Math.Round(countTiles));


