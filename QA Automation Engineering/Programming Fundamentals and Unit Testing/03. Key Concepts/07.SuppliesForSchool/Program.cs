int pencilCount = int.Parse(Console.ReadLine());
int markersCount = int.Parse(Console.ReadLine());
int boardCleanerLiters = int.Parse(Console.ReadLine());
int discountPercent = int.Parse(Console.ReadLine()); 


double pencilPrice = 5.80;
double markersPrice = 7.20;
double boardPrice = 1.20;



double totalSum = (pencilCount * pencilPrice) + (markersCount * markersPrice) + (boardCleanerLiters * boardPrice);


double discountAsNumber = discountPercent / 100.0; 
totalSum = totalSum - totalSum * discountAsNumber;

Console.WriteLine(totalSum);



