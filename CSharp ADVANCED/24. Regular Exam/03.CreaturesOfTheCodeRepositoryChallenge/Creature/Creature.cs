using System;
using System.Collections.Generic;
using System.Linq;

namespace CreaturesOfTheCode
{
    public class Creature
    {
       
        public string Name { get; set; }
        public string Kind { get; set; }
        public int Health { get; set; }
        public List<string> Abilities { get; set; }

        
        public Creature(string name, string kind, int health, string abilities)
        {
            Name = name;
            Kind = kind;
            Health = health;
            Abilities = abilities.Split(", ", StringSplitOptions.RemoveEmptyEntries).ToList();
        }

       
        public override string ToString()
        {
            return $"{Name} ({Kind}) has {Health} HP" + Environment.NewLine +
                   $"Abilities: {string.Join(", ", Abilities)}";
        }
    }
}
