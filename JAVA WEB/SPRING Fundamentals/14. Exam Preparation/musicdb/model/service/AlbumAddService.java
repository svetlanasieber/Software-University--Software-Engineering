package com.example.musicdb.model.service;

import com.example.musicdb.model.enums.GenreEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddService {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    public long getArtist() {
        return artist;
    }

    public void setArtist(long artist) {
        this.artist = artist;
    }

    @NotBlank
    @Size(min = 5)
    private String imageUrl;

    @NotBlank
    @Size(min = 5)
    private String description;

    @Min(10)
    private int copies;

    @Positive
    private BigDecimal price;


    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private String producer;

    @NotNull
    private GenreEnum genre;

    @NotNull
    private long artist;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public AlbumAddService() {
    }


}
