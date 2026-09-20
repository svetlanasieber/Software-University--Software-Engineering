using LegendsOfValor_TheGuildTrials.Core;
using LegendsOfValor_TheGuildTrials.Core.Contracts;
using LegendsOfValor_TheGuildTrials.IO;
using LegendsOfValor_TheGuildTrials.IO.Contracts;

namespace AccessControlSystem.Core
{
    public class Engine : IEngine
    {
        private IReader reader;
        private IWriter writer;
        private IController controller;

        public Engine()
        {
            reader = new Reader();
            writer = new Writer();
            controller = new Controller();
        }
        public void Run()
        {
            while (true)
            {
                string[] input = reader.ReadLine().Split();
                if (input[0] == "Exit")
                {
                    Environment.Exit(0);
                }
                try
                {
                    string result = string.Empty;

                    if (input[0] == "AddHero")
                    {
                        string heroTypeName = input[1];
                        string heroName = input[2];
                        string runeMark = input[3];

                        result = controller
                            .AddHero(heroTypeName, heroName, runeMark);
                    }
                    else if (input[0] == "CreateGuild")
                    {
                        string guildName = input[1];

                        result = controller
                            .CreateGuild(guildName);
                    }
                    else if (input[0] == "RecruitHero")
                    {
                        string runeMark = input[1];
                        string guildName = input[2];

                        result = controller
                            .RecruitHero(runeMark, guildName);
                    }
                    else if (input[0] == "TrainingDay")
                    {
                        string guildName = input[1];

                        result = controller
                            .TrainingDay(guildName);
                    }
                    else if (input[0] == "StartWar")
                    {
                        string attackerGuildName = input[1];
                        string defenderGuildName = input[2];

                        result = controller
                            .StartWar(attackerGuildName, defenderGuildName);
                    }
                    else if (input[0] == "ValorState")
                    {
                        result = controller.ValorState();
                    }
                    writer.WriteLine(result);
                    writer.WriteText(result);
                }
                catch (Exception ex)
                {
                    writer.WriteLine(ex.Message);
                    writer.WriteText(ex.Message);
                }
            }
        }
    }
}
