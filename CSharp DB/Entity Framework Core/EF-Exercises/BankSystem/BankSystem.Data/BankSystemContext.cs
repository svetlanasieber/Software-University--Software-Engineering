using BankSystem.Models;
using Microsoft.EntityFrameworkCore;
using System;

namespace BankSystem.Data
{
    public class BankSystemContext :DbContext
    {
        public DbSet<User> Users { get; set; }
        public DbSet<SavingAccount> SavingAccounts { get; set; }
        public DbSet<CheckingAccount> CheckingAccounts { get; set; }




        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Server=.; Database=BankSystem; Trusted_connection=true");
            base.OnConfiguring(optionsBuilder);


        }


        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {


        }
    }
}
