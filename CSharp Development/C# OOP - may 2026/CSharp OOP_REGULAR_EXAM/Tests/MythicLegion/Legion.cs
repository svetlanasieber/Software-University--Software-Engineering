namespace MythicLegion
{
    public class Legion
    {
        private List<Hero> heroes;

        public Legion()
        {
            heroes = new List<Hero>();
        }

        public void AddHero(Hero hero)
        {
            if (hero == null)
            {
                throw new ArgumentNullException(nameof(hero), "Hero cannot be null");
            }
            if(heroes.Any(h => h.Name == hero.Name))
            {
                throw new ArgumentException($"Hero with name {hero.Name} already exists in the legion.");
            }
            heroes.Add(hero);
        }

        public bool RemoveHero(string name)
        {
            var hero = heroes.FirstOrDefault(h => h.Name == name);
            if (hero != null)
            {
                heroes.Remove(hero);
                return true;
            }
            else
            {
                return false;
            }
        }

        public string TrainHero(string name)
        {
            var hero = heroes.FirstOrDefault(h => h.Name == name);
            if (hero != null)
            {
                hero.Health += 1;
                hero.Power += 10;
                hero.IsTrained = true;
                return $"{hero.Name} has been trained.";
            }
            else
            {
                return $"Hero with name {name} not found.";
            }
        }

        public string GetLegionInfo()
        {
            if (heroes.Count == 0)
            {
                return "No heroes in the legion.";
            }
            var heroInfo = heroes.Select(h => h.ToString()).ToList();
            return string.Join(Environment.NewLine, heroInfo);
        }
    }
}
