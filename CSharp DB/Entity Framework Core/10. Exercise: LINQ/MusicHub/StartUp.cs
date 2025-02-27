namespace MusicHub
{
    using System;
    using System.Text;
    using Data;

    public class StartUp
    {
        public static void Main()
        {
            MusicHubDbContext context =
                new MusicHubDbContext();

            Console.WriteLine(ExportSongsAboveDuration(context, 120));
        }

        public static string ExportAlbumsInfo(MusicHubDbContext context, int producerId)
        {
            var albumsInfo = context.Producers
                .First(p => p.Id == producerId)
                .Albums.Select(a => new
                {
                    AlbumName = a.Name,
                    ReleaseDate = a.ReleaseDate.ToString("MM/dd/yyyy"),
                    ProducerName = a.Producer.Name,
                    Songs = a.Songs.Select(s => new
                    {
                        SongName = s.Name,
                        SongPrice = s.Price,
                        SongWriterName = s.Writer.Name,

                    })
                    .OrderByDescending(s => s.SongName)
                    .ThenBy(s => s.SongWriterName),
                    AlbumPrice = a.Price,
                })
                .OrderByDescending(a => a.AlbumPrice)
                .ToArray(); 

            StringBuilder sb = new StringBuilder();

            foreach (var a in albumsInfo)
            {
                sb.AppendLine($"-AlbumName: {a.AlbumName}");
                sb.AppendLine($"-ReleaseDate: {a.ReleaseDate}");
                sb.AppendLine($"-ProducerName: {a.ProducerName}");

                int count = 1;

                if (a.Songs.Any())
                {
                    sb.AppendLine($"-Songs:");

                    foreach (var s in a.Songs)
                    {
                        sb.AppendLine($"---#{count}");
                        sb.AppendLine($"---SongName: {s.SongName}");
                        sb.AppendLine($"---Price: {s.SongPrice:f2}");
                        sb.AppendLine($"---Writer: {s.SongWriterName}");

                        count++;
                    }
                }                              

                sb.AppendLine($"-AlbumPrice: {a.AlbumPrice:f2}");
            }

            return sb.ToString().Trim();
        }

        public static string ExportSongsAboveDuration(MusicHubDbContext context, int duration)
        {
            var songsInfo = context.Songs
                .AsEnumerable()
                .Where(s => s.Duration.TotalSeconds > duration)
                .Select(s => new
                {
                    SongName = s.Name,
                    SongDuration = s.Duration.ToString("c"),
                    PerformerNames = s.SongPerformers
                    .Select(sp => new
                    {
                        PerformerFullName = $"{sp.Performer.FirstName} {sp.Performer.LastName}",
                    })
                    .OrderBy(n => n.PerformerFullName),
                    SongWriterName = s.Writer.Name,
                    AlbumProducerName = s.Album.Producer.Name,
                })
                .OrderBy(s => s.SongName)
                .ThenBy(s => s.SongWriterName)
                .ToList();

            StringBuilder sb = new StringBuilder();

            int count = 1;

            if (songsInfo.Any())
            {
                foreach (var s in songsInfo)
                {
                    sb.AppendLine($"-Song #{count}");
                    sb.AppendLine($"---SongName: {s.SongName}");
                    sb.AppendLine($"---Writer: {s.SongWriterName}");

                    if (s.PerformerNames.ToList().Any())
                    {
                        foreach (var p in s.PerformerNames)
                        {
                            sb.AppendLine($"---Performer: {p.PerformerFullName}");
                        }                        
                    }

                    sb.AppendLine($"---AlbumProducer: {s.AlbumProducerName}");
                    sb.AppendLine($"---Duration: {s.SongDuration}");

                    count++;
                }
            }            

            return sb.ToString().Trim();
        }
    }
}
