using LegendsOfValor_TheGuildTrials.Models.Contracts;
using LegendsOfValor_TheGuildTrials.Repositories.Contratcs;

namespace LegendsOfValor_TheGuildTrials.Repositories
{
    public class GuildRepository : IRepository<IGuild>
    {
        private readonly List<IGuild> guilds;
        public GuildRepository()
        {
            guilds = new List<IGuild>();
        }

        public void AddModel(IGuild guild)
        {
            guilds.Add(guild);
        }

        public IReadOnlyCollection<IGuild> GetAll()
        {
            return guilds.AsReadOnly();
        }

        public IGuild GetModel(string guildName)
        {
            return guilds.FirstOrDefault(g => g.Name == guildName);
        }
    }
}
