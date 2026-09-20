namespace LegendsOfValor_TheGuildTrials.Repositories.Contratcs
{
    public interface IRepository<T> where T : class
    {
        void AddModel(T entity);

        T GetModel(string runeMarkOrGuildName);
        IReadOnlyCollection<T> GetAll();
    }
}
