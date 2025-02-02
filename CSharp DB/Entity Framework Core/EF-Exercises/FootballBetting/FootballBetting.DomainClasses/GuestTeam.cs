namespace FootballBetting.DomainClasses
{
    public class GuestTeam
    {
        public int HostTownId { get; set; }
        public Town HostTown { get; set; }

        public int GuestTeamId { get; set; }
        public Team GetTeam { get; set; }

    }
}