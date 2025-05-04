namespace P01.Stream_Progress.Models.Interfaces;

public interface IStream
{
    int Length { get; set; }

    int BytesSent { get; set; }
}
