package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.ArtistEntity;
import com.example.musicdb.model.enums.ArtistEnum;
import com.example.musicdb.repository.ArtistRepository;
import com.example.musicdb.service.ArtistService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void initArtists() {
        if (artistRepository.count() > 0) {
            return;
        }
        Arrays.stream(ArtistEnum.values()).forEach(artistEnum -> {
            ArtistEntity artist = new ArtistEntity();
            artist.setName(artistEnum);
            try {
                artist.setCareerInformation(addCareerInformation(artistEnum));
            } catch (IOException e) {
                e.printStackTrace();
            }
            artistRepository.save(artist);
        });
    }

    @Override
    public List<ArtistEntity> findAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public ArtistEntity findById(long artistId) {
        return artistRepository.findById(artistId).orElse(null);
    }

    private String addCareerInformation(ArtistEnum artistEnum) throws IOException {
        String content = "";
        switch (artistEnum) {
            case QUEEN -> {
                content = Files.readString(Path.of("C:\\Users\\kolev\\Desktop\\SoftUni\\JavaWeb\\SpringFundamentals-ExamPreps\\Music DB\\src\\main\\resources\\CareerInformation\\Queen.txt"));
            }
            case METALLICA -> {
                content = Files.readString(Path.of("C:\\Users\\kolev\\Desktop\\SoftUni\\JavaWeb\\SpringFundamentals-ExamPreps\\Music DB\\src\\main\\resources\\CareerInformation\\Metallica.txt"));
            }
            case MADONNA -> {
                content = Files.readString(Path.of("C:\\Users\\kolev\\Desktop\\SoftUni\\JavaWeb\\SpringFundamentals-ExamPreps\\Music DB\\src\\main\\resources\\CareerInformation\\Madonna.txt"));
            }
        }
        return content;

    }
}
