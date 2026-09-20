namespace MythicLegion
{
    public class Hero
    {
        public Hero(string name, string type)
        {
            Name = name;
            Type = type;
        }

        public string Name { get; set; }
        public string Type { get; set; }
        public int Power { get; set; } = 20;    
        public int Health { get; set; } = 100;
        public bool IsTrained { get; set; } = false;

        public override string ToString()
        {
            return $"{Name} ({Type}) - Power: {Power}, Health: {Health}, Trained: {IsTrained}";
        }
    }
}
