namespace LegendsOfValor_TheGuildTrials.Models.Contracts
{
    public interface IGuild
    {
        string Name { get; }

        int Wealth { get; }

        IReadOnlyCollection<string> Legion { get; }

        bool IsFallen { get; }

        void RecruitHero(IHero hero);

        void TrainLegion(ICollection<IHero> heroesToTrain);

        void WinWar(int goldAmount);

        void LoseWar();
    }
}
