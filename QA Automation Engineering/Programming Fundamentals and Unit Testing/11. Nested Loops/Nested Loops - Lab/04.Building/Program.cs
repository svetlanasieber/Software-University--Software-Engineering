int floors = int.Parse(Console.ReadLine());
int estates = int.Parse(Console.ReadLine());


for (int floor = floors; floor >= 1; floor--)
{
   
    for (int estate = 0; estate < estates; estate++)
    {
        
        if (floor == floors)
        {
           
            Console.Write($"L{floor}{estate} ");
        }
        else if (floor % 2 == 0)
        {
           
            Console.Write($"O{floor}{estate} ");
        }
        else
        {
            
            Console.Write($"A{floor}{estate} ");
        }
    }

    Console.WriteLine(); 
}
