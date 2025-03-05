namespace MusicHub.Data.Models;

using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

public class Album
{
    public Album()
    {
        this.Songs = new HashSet<Song>();
    }

    [Key]
    public int Id { get; set; }

    //[Unicode(false)]
    [MaxLength(ValidationConstants.AlbumNameMaxLength)]
    public string Name { get; set; } = null!;


    public DateTime ReleaseDate { get; set; }

    [NotMapped]//Excludes the property from the DB
    public decimal Price => this.Songs.Sum(s => s.Price);


    [ForeignKey(nameof(Producer))]
    public int? ProducerId { get; set; }
    public virtual Producer? Producer { get; set; }


    public virtual ICollection<Song> Songs { get; set; }
    
}

