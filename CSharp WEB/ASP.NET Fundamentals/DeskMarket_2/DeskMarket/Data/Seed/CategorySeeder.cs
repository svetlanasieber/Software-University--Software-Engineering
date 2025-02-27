namespace DeskMarket.Data.Seed
{
    using DeskMarket.Data.Models;

    public static class CategorySeeder
    {
        public static IEnumerable<Category> Seed()
        {
            return new Category[]
            {
                new() { Id = 1, Name = "Laptops" },
                new() { Id = 2, Name = "Workstations" },
                new() { Id = 3, Name = "Accessories" },
                new() { Id = 4, Name = "Desktops" },
                new() { Id = 5, Name = "Monitors" }
            };
        }
    }
}
