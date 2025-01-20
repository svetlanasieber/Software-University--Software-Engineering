package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.AlbumEntity;
import com.example.musicdb.model.service.AlbumAddService;
import com.example.musicdb.model.view.AlbumViewModel;
import com.example.musicdb.repository.AlbumRepository;
import com.example.musicdb.service.AlbumService;
import com.example.musicdb.service.ArtistService;
import com.example.musicdb.service.UserService;
import com.example.musicdb.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final ModelMapper modelMapper;
    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public AlbumServiceImpl(ModelMapper modelMapper, AlbumRepository albumRepository, ArtistService artistService, CurrentUser currentUser, UserService userService) {
        this.modelMapper = modelMapper;
        this.albumRepository = albumRepository;
        this.artistService = artistService;

        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addAlbum(AlbumAddService albumAddService) {
        AlbumEntity newAlbum = modelMapper.map(albumAddService, AlbumEntity.class);
        newAlbum.setArtist(artistService.findById(albumAddService.getArtist()));
        newAlbum.setAddedFrom(userService.findById(currentUser.getId()));
        albumRepository.save(newAlbum);
    }


    @Override
    public int countAllCopies() {
        int copies = albumRepository.findAll().stream().map(albumEntity -> albumEntity.getCopies()).reduce((a, b) -> a + b).orElse(1000);

        return copies;
    }

    @Override
    public List<AlbumViewModel> getAllAlbums() {
        return albumRepository.findAll().stream().map(albumEntity -> {
            AlbumViewModel avm = modelMapper.map(albumEntity, AlbumViewModel.class);
            String artistName= albumEntity.getArtist().getName().name();
            avm.setPicSource(artistName.toLowerCase(Locale.ROOT));

            avm.setArtistName(artistName.substring(0, 1).toUpperCase() + artistName.substring(1).toLowerCase(Locale.ROOT));
            avm.setAlbumId(albumEntity.getId());
            return avm;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
