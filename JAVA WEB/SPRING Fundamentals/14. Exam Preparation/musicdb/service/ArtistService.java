package com.example.musicdb.service;


import com.example.musicdb.model.entity.ArtistEntity;

public interface ArtistService {
    void initArtists();

    Object findAllArtists();

    ArtistEntity findById(long artist);
}
