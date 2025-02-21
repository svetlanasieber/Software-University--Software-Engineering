using DeskMarket.Data.Models;
using DeskMarket.Data.Seeding;
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

        public virtual DbSet<Category> Categories { get; set; } = null!;

        public virtual DbSet<Product> Products { get; set; } = null!;

        public virtual DbSet<ProductClient> ProductsClients { get; set; } = null!;

        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);

            builder.Entity<Product>()
                .HasQueryFilter(p => !p.IsDeleted);

            builder.Entity<Product>()
                .Property(p => p.Price)
                .HasColumnType("decimal(18,2)");

            builder.Entity<Product>()
               .HasOne(p => p.Category)
               .WithMany(c => c.Products)
               .HasForeignKey(p => p.CategoryId)
               .OnDelete(DeleteBehavior.Cascade);

            builder.Entity<Product>()
                .HasOne(p => p.Seller)
                .WithMany()
                .HasForeignKey(p => p.SellerId)
                .OnDelete(DeleteBehavior.Restrict);

            builder.Entity<ProductClient>()
                .HasKey(pc => new { pc.ProductId, pc.ClientId });

            builder.Entity<ProductClient>()
               .HasOne(pc => pc.Product)
               .WithMany(p => p.ProductsClients)
               .HasForeignKey(pc => pc.ProductId)
               .OnDelete(DeleteBehavior.Cascade);

            builder.Entity<ProductClient>()
                .HasOne(pc => pc.Client)
                .WithMany()
                .HasForeignKey(pc => pc.ClientId)
                .OnDelete(DeleteBehavior.Cascade);
        }
    }
}
