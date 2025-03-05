namespace MusicHub;

using System;
using System.Globalization;
using System.Text;
using Data;

using Initializer;


public class StartUp
{
    public static void Main()
    {
        MusicHubDbContext context =
            new MusicHubDbContext();

        DbInitializer.ResetDatabase(context);

        //Test your solutions here
        string result = ExportAlbumsInfo(context, 9);
        Console.WriteLine(result);
    }

    public static string ExportAlbumsInfo(MusicHubDbContext context, int producerId)
    {
        StringBuilder sb = new StringBuilder();

        var albumsInfo = context.Albums
            .Where(a => a.ProducerId.HasValue &&
                         a.ProducerId.Value == producerId)
            .ToArray()
            .OrderByDescending(a => a.Price)
            .Select(a => new
            {
                a.Name,
                ReleaseDate = a.ReleaseDate
                    .ToString("MM/dd/yyyy", CultureInfo.InvariantCulture),
                ProducerName = $"{a.Producer.Name}",
                Songs = a.Songs
                        .Select(s => new
                        {
                            SongName = s.Name,
                            Price = s.Price.ToString("f2"),
                            Writer = s.Writer.Name
                        })
                        .OrderByDescending(s => s.SongName)
                        .ThenBy(s => s.Writer)
                        .ToArray(),
                AlbumPrice = a.Price.ToString("f2")
            })
            .ToArray();

        foreach (var a in albumsInfo)
        {
            sb.AppendLine($"-AlbumName: {a.Name}")
                .AppendLine($"-ReleaseDate: {a.ReleaseDate}")
                .AppendLine($"-ProducerName: {a.ProducerName}")
                .AppendLine($"-Songs:");
            int songNumber = 1;
            foreach (var s in a.Songs)
            {
                sb
                    .AppendLine($"---#{songNumber}")
                    .AppendLine($"---SongName: {s.SongName}")
                    .AppendLine($"---Price: {s.Price}")
                    .AppendLine($"---Writer: {s.Writer}");
                songNumber++;
            }
            sb.AppendLine($"-AlbumPrice: {a.AlbumPrice}");
        }
        return sb.ToString().TrimEnd();
    }



    public static string ExportSongsAboveDuration(MusicHubDbContext context, int duration)
    {
        throw new NotImplementedException();
    }
}
