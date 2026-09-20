namespace LegendsOfValor_TheGuildTrials.Models.Contracts
{
    public interface IHero
    {
        string Name { get; }

        string RuneMark { get; }

        string GuildName { get; }

        int Power { get; }

        int Mana { get; }

        int Stamina { get; }

        void JoinGuild(IGuild guild);

        abstract void Train();

        string Essence();
    }
}
