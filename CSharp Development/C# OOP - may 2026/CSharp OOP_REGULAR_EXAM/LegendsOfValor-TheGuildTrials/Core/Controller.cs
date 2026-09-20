using LegendsOfValor_TheGuildTrials.Core.Contracts;
using LegendsOfValor_TheGuildTrials.Repositories;

namespace LegendsOfValor_TheGuildTrials.Core
{
    public class Controller : IController
    {
        private readonly HeroRepository heroes;
        private readonly GuildRepository guilds;

        public Controller()
        {
            heroes = new HeroRepository();
            guilds = new GuildRepository();
        }

        public string AddHero(string heroTypeName, string heroName, string runeMark)
        {
            throw new NotImplementedException();
        }

        public string CreateGuild(string guildName)
        {
            throw new NotImplementedException();
        }

        public string RecruitHero(string runeMark, string guildName)
        {
            throw new NotImplementedException();
        }

        public string StartWar(string attackerGuildName, string defenderGuildName)
        {
            throw new NotImplementedException();
        }

        public string TrainingDay(string guildName)
        {
            throw new NotImplementedException();
        }

        public string ValorState()
        {
            throw new NotImplementedException();
        }
    }
}
