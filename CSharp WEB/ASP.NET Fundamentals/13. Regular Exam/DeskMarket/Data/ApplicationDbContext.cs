using DeskMarket.Data.Models;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;

namespace DeskMarket.Data
{
    public class ApplicationDbContext : IdentityDbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        public DbSet<Product> Products { get; set; }

        public DbSet<Category> Categories { get; set; }

        public DbSet<ProductClient> ProductsClients { get; set; }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder
                .Entity<ProductClient>()
                .Property(pc => pc.IsDeleted)
                .HasDefaultValue(false);

            builder
                .Entity<Product>()
                .Property(p => p.IsDeleted)
                .HasDefaultValue(false);

            builder
                .Entity<ProductClient>()
                .HasKey(pc => new { pc.ClientId, pc.ProductId });

            builder
                .Entity<ProductClient>()
                .HasOne(pc => pc.Client)
                .WithMany()
                .HasForeignKey(pc => pc.ClientId)
                .OnDelete(DeleteBehavior.NoAction);

            builder
                .Entity<ProductClient>()
                .HasOne(pc => pc.Product)
                .WithMany()
                .HasForeignKey(pc => pc.ProductId)
                .OnDelete(DeleteBehavior.NoAction);

            base.OnModelCreating(builder);

            builder
                .Entity<Category>()
                .HasData(
                    new Category { Id = 1, Name = "Laptops" },
                    new Category { Id = 2, Name = "Workstations" },
                    new Category { Id = 3, Name = "Accessories" },
                    new Category { Id = 4, Name = "Desktops" },
                    new Category { Id = 5, Name = "Monitors" });
        }
    }
}
