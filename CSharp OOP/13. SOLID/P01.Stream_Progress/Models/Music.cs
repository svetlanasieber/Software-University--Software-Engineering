using P01.Stream_Progress.Models.Interfaces;

namespace P01.Stream_Progress.Models;

public class Music : IStream
{
    private string artist;
    private string album;

    public Music(string artist, string album, int length, int bytesSent)
    {
        this.artist = artist;
        this.album = album;
        Length = length;
        BytesSent = bytesSent;
    }

    public int Length { get; set; }

    public int BytesSent { get; set; }
}
