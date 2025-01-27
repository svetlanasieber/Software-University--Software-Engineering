namespace DeskMarket.Common.Extensions
{
    using DeskMarket.Data;
    using DeskMarket.Services.Category;
    using DeskMarket.Services.Product;
    using Microsoft.AspNetCore.Identity;
    using Microsoft.EntityFrameworkCore;

    public static class ServiceCollection
    {
        public static void AddServices(this IServiceCollection services)
        {
            services.AddControllersWithViews();
            services.AddAutoMapper(typeof(Program).Assembly);
            services.AddTransient<ICategoryService, CategoryService>();
            services.AddTransient<IProductService, ProductService>();
        }

        public static void AddApplicationDbContext(
            this IServiceCollection services,
            IConfiguration configuration,
            IHostEnvironment environment)
        {
            var connectionString = configuration
               .GetConnectionString("DefaultConnection")
               ?? throw new InvalidOperationException("Connection string 'DefaultConnection' not found.");

            services
                .AddDbContext<ApplicationDbContext>(options =>
                {
                    options.UseSqlServer(connectionString);
                });

            if (environment.IsDevelopment())
            {
                services.AddDatabaseDeveloperPageExceptionFilter();
            }

            services
                .AddDefaultIdentity<IdentityUser>(options =>
                {
                    options.SignIn.RequireConfirmedAccount = false;
                    options.Password.RequireDigit = false;
                    options.Password.RequireNonAlphanumeric = false;
                    options.Password.RequireUppercase = false;
                })
                .AddEntityFrameworkStores<ApplicationDbContext>();
        }
    }
}
