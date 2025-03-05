namespace MusicHub.Data.Models;

using MusicHub.Data.Models.Enums;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

public class Song
{
    public Song()
    {
        this.SongPerformers = new HashSet<SongPerformer>();
    }


    [Key]
    public int Id { get; set; }


    //In EF <= 3.1.x we use [Required] attribute
    //In EF >=6.x everything is required and we add "?" to be nullable
    [MaxLength(ValidationConstants.SongNameMaxLength)]
    public string Name { get; set; } = null!;//this is required


    //TimeSpan datatype is required by default!
    //In the DB this will be stored as BIGINT <=> Ticks count
    public TimeSpan Duration { get; set; }//required by default

    public DateTime CreatedOn { get; set; }//required by default


    public Genre Genre { get; set; }//required by default


    [ForeignKey(nameof(Album))]
    public int? AlbumId { get; set; }//not required, nullable int
    public virtual Album? Album { get; set; }


    [ForeignKey(nameof(Writer))]
    public int WriterId { get; set; }
    public virtual Writer Writer { get; set; } = null!;//required


    public decimal Price { get; set; }


    public virtual ICollection<SongPerformer> SongPerformers { get; set; }


}

