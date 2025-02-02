
namespace FootballBetting.Data
{
    using FootballBetting.DomainClasses;
    using Microsoft.EntityFrameworkCore;
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.Linq;

    public class FootbalBettingContext : DbContext
    {
        public DbSet<Team> Teams {get; set;}
        public DbSet<Town> Towns { get; set; }
        public DbSet<Color> Colors { get; set; }
        public DbSet<Country> Countries { get; set; }
        public DbSet<Continent> Continents { get; set; }
        public DbSet<Player> Players { get; set; }
        public DbSet<Position> Positions { get; set; }
        public DbSet<PlayerStatistic> PlayersStatistics { get; set; }
        public DbSet<Game> Games { get; set; }
        public DbSet<Round> Rounds { get; set; }
        public DbSet<Competition> Competitions { get; set; }
        public DbSet<CompetitionType> CompetitionTypes { get; set; }
        public DbSet<BetGame> BetGames { get; set; }
        public DbSet<Bet> Bets { get; set; }
        public DbSet<ResultPrediction> ResultPredictions { get; set; }
        public DbSet<User> Users { get; set; }
        //public DbSet<CountryContinent> CountriesContinents { get; set; }



       

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Server=.; Database=FootballBetting; Trusted_Connection=True");

        }


        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            #region team games one-to-many away gost

            modelBuilder
                .Entity<Team>()
                .HasMany(g => g.HomeGames)
                .WithOne(t => t.HomeTeam);

            modelBuilder
                .Entity<Team>()
                .HasMany(g => g.AwayGames)
                .WithOne(t => t.AwayYeam);

#endregion


            #region County-Continents- Many to many

            modelBuilder
                            .Entity<CountryContinent>()
                            .HasKey(k => new { k.ContinentId, k.CountryId });

            modelBuilder
                .Entity<Country>()
                .HasMany(c => c.Continents)
                .WithOne(c => c.Country)
                .HasForeignKey(c=>c.CountryId)
                .OnDelete(DeleteBehavior.Restrict);

            modelBuilder
                .Entity<Continent>()
                .HasMany(c => c.Countries)
                .WithOne(c => c.Continent)
                .HasForeignKey(c=>c.ContinentId)
                .OnDelete(DeleteBehavior.Restrict);

                        //modelBuilder
                        //    .Entity<CountryContinent>()
                        //    .HasOne(c => c.Country)
                        //    .WithMany(c => c.Continents)
                        //    .OnDelete(DeleteBehavior.Restrict);

                        //modelBuilder
                        //    .Entity<CountryContinent>()
                        //    .HasOne(c => c.Continent)
                        //    .WithMany(c => c.Countries)
                        //    .OnDelete(DeleteBehavior.Restrict);
            #endregion
 

            #region Player-Games- Statistics ManyToMany
            modelBuilder
                .Entity<PlayerStatistic>()
                .HasKey(k => new { k.GameId, k.PlayerId });

            modelBuilder
                .Entity<PlayerStatistic>()
                .HasOne(p => p.Player)
                .WithMany(g => g.GameStatistics)
                .OnDelete(DeleteBehavior.Restrict);

            modelBuilder
                .Entity<PlayerStatistic>()
                .HasOne(g => g.Game)
                .WithMany(p => p.PlayerStatistics)
                .OnDelete(DeleteBehavior.Restrict);

            #endregion

            #region Bet-Game Many to Many
            modelBuilder
                .Entity<BetGame>()
                .HasKey(k => new { k.BetId, k.GameId });

            modelBuilder
                .Entity<BetGame>()
                .HasOne(b => b.Bet)
                .WithMany(g => g.Games)
                .OnDelete(DeleteBehavior.Restrict);

            modelBuilder
                .Entity<BetGame>()
                .HasOne(g => g.Game)
                .WithMany(b => b.Bets)
                .OnDelete(DeleteBehavior.Restrict);

            #endregion


            #region Colors-Team home one to many

            modelBuilder
                .Entity<Color>()
                .HasMany(ht => ht.HomeTeams)
                .WithOne(c => c.PrimaryColor)
                .OnDelete(DeleteBehavior.Restrict);

            modelBuilder
                .Entity<Color>()
                .HasMany(ac => ac.GuestTeams)
                .WithOne(c => c.SecondaryColor)
                .OnDelete(DeleteBehavior.Restrict);


#endregion
            // base.OnModelCreating(modelBuilder);
        }

        public override int SaveChanges()
        {

            var changedEntities = ChangeTracker
            .Entries()
            .Where(_ => _.State == EntityState.Added ||
                        _.State == EntityState.Modified);

            var errors = new List<ValidationResult>(); // all errors are here
            foreach (var e in changedEntities)
            {
                var vc = new ValidationContext(e.Entity, null, null);
               if( Validator.TryValidateObject(e.Entity, vc, errors, true)==false)
                {
                    foreach (var error in errors)
                    {
                        if (error!= ValidationResult.Success)
                        {

                            throw new ValidationException(error.ErrorMessage);

                        }

                    }

                }
            }

            
            return base.SaveChanges();
        }


    }
}
