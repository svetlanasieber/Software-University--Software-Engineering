using FootballBetting.Data;
using Microsoft.EntityFrameworkCore;
using System;

namespace FootballBetting.Client
{
    public class Startup
    {
        static void Main( )
        {
            using (var db= new FootbalBettingContext() )
            {
                db.Database.Migrate();
                //db.Database.EnsureCreated();
                Console.WriteLine("OK");
            }
        }
    }
}
