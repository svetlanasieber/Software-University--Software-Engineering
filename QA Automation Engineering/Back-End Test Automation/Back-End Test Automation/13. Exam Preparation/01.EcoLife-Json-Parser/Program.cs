using System.Text.Json;
using JsonParser.Models;

namespace JsonParser
{
    class Program
    {
        static void Main(string[] args)
        {
            ParseSpecies();
        }

        // Parses and displays species data
        private static void ParseSpecies()
        {
            string jsonFilePath = Path.Combine("Datasets", "Species.json");
            try
            {
                string json = File.ReadAllText(jsonFilePath);
                List<Species>? species = JsonSerializer.Deserialize<List<Species>>(json);
                DisplaySpecies(species);
            }
            catch (Exception e)
            {
                HandleError(e);
            }
        }

        // Displays the list of species
        private static void DisplaySpecies(List<Species>? species)
        {
            if (species == null)
            {
                Console.WriteLine("No species data found or data is not in the expected format.");
                return;
            }

            Console.WriteLine("Animals:");
            for(int i = 0; i < species.Count; i++)
            {
                Console.WriteLine($"Animal #{i+1}");
                Console.WriteLine($"ID: {species[i].SpeciesId} Name: {species[i].SpeciesName}");
                Console.WriteLine($"Habitat: {species[i].Habitat}, Lifespan: {species[i].Lifespan}");
                string habits = string.Join(", ", species[i].Habits.Diet);
                Console.WriteLine($"Diet: {habits}, Migration: {species[i].Habits.Migration}"); 
            }
        }

        // Handles errors that occur during JSON parsing
        private static void HandleError(Exception e)
        {
            if (e is JsonException)
            {
                Console.WriteLine($"JSON Parsing Error: {e.Message}");
            }
            else
            {
                Console.WriteLine($"An unexpected error occurred: {e.Message}");
            }
        }
    }
}