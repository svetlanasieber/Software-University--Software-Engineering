namespace DeskMarket.Services.Common
{
    using DeskMarket.Data.Models;
    using Microsoft.EntityFrameworkCore;

    public static class Extensions
    {
        public static IQueryable<Product> All(this DbSet<Product> products) => products.Where(p => !p.IsDeleted);
        
        public static IQueryable<Product> AllAsNoTracking(this DbSet<Product> products) => products.AsNoTracking().Where(p => !p.IsDeleted); 
    }
}
