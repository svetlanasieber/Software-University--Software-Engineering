package com.example.musicdb.service;


import com.example.musicdb.model.service.AlbumAddService;
import com.example.musicdb.model.view.AlbumViewModel;

import java.util.List;


public interface AlbumService {
    void addAlbum(AlbumAddService map);


    int countAllCopies();

    List<AlbumViewModel> getAllAlbums();

    void deleteAlbum(Long id);
}
