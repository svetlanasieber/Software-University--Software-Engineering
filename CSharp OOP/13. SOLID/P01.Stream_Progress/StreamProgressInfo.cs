using P01.Stream_Progress.Models.Interfaces;

namespace P01.Stream_Progress;

public class StreamProgressInfo
{
    private IStream stream;

    public StreamProgressInfo(IStream stream)
    {
        this.stream = stream;
    }

    public int CalculateCurrentPercent()
    {
        return stream.BytesSent * 100 / stream.Length;
    }
}
