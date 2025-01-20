package com.example.musicdb.model.view;

import com.example.musicdb.model.entity.ArtistEntity;
import com.example.musicdb.model.entity.UserEntity;
import com.example.musicdb.model.enums.GenreEnum;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    private Long albumId;

    private String name;


    private int copies;


    private BigDecimal price;


    private LocalDate releaseDate;


    @Column(nullable = false)
    private GenreEnum genre;

    private String artistName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getPicSource() {
        return picSource;
    }

    public void setPicSource(String picSource) {
        this.picSource = picSource;
    }

    public AlbumViewModel() {
    }

    @ManyToOne
    private String picSource;
}
