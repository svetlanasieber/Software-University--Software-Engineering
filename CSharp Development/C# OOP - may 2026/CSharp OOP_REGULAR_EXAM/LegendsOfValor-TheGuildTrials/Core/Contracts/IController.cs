namespace LegendsOfValor_TheGuildTrials.Core.Contracts
{
    public interface IController
    {
        string AddHero(string heroTypeName, string heroName, string runeMark);

        string CreateGuild(string guildName);

        string RecruitHero(string runeMark, string guildName);

        string TrainingDay(string guildName);

        string StartWar(string attackerGuildName, string defenderGuildName);

        string ValorState();
    }
}
