using P01.Stream_Progress.Models;
using System;

namespace P01.Stream_Progress;

public class Program
{
    static void Main()
    {

        StreamProgressInfo fileProgress = new(new File("text.txt", 4, 100));

        Console.WriteLine(fileProgress.CalculateCurrentPercent());

        StreamProgressInfo musicProgress = new(new Music("Dream Theater", "Images And Words", 320, 1000));

        Console.WriteLine(musicProgress.CalculateCurrentPercent());
    }
}
