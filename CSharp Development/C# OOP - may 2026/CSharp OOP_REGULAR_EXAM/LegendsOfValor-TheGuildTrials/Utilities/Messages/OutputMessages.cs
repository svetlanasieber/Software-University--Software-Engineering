using LegendsOfValor_TheGuildTrials.Models;
using LegendsOfValor_TheGuildTrials.Repositories;
using System;

namespace LegendsOfValor_TheGuildTrials.Utilities.Messages
{
    public static class OutputMessages
    {
        //AddHero
        public const string HeroAdded = "{0} {1} awakened with RuneMark {2}.";
        public const string HeroAlreadyExists = "A hero bearing the RuneMark {0} already walks among us.";
        public const string InvalidHeroType = "The winds whisper no knowledge of a {0}.";

        //CreateGuild
        public const string GuildCreated = "Guild {0} has been founded with 5000 gold.";
        public const string GuildAlreadyExists = "The banners of {0} already fly high in the realm.";

        //RecruitHero
        public const string HeroRecruited = "Hero {0} has joined the {1}.";
        public const string HeroAlreadyInGuild = "Hero {0} has already sworn loyalty to a guild.";
        public const string GuildIsFallen = "The {0} lies in ruin and cannot accept new champions.";
        public const string GuildCannotAffordRecruitment = "The coffers of the {0} run dry — recruitment is impossible.";
        public const string HeroTypeNotCompatible = "The path of the {0} does not align with the {1}.";
        public const string HeroNotFound = "No hero bearing the RuneMark {0} walks this realm.";
        public const string GuildNotFound = "No guild known as {0} has been founded.";

        //TrainingDay
        public const string TrainingDayStarted = "{0} has completed training for {1} heroes – costing {2} gold.";
        public const string TrainingDayFailed = "The coffers of the {0} cannot bear the weight of this training day.";
        public const string GuildTrainingDayIsFallen = "The fallen {0} can no longer rally its legion.";

        //StartWar
		public const string OneOfTheGuildsDoesNotExist = "The clash cannot commence — one or more guilds are yet to be founded.";
		public const string OneOfTheGuildsIsFallen = "The clash cannot commence — one or more guilds have fallen.";
        public const string WarWon = "War won! {0} has vanquished {1} and claimed {2} gold.";
        public const string WarLost = "War lost! {0} has defended valiantly and claimed {1} gold from {2}.";
    }
}
