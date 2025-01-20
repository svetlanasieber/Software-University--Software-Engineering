package com.example.musicdb;

import com.example.musicdb.service.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDBInitializer implements CommandLineRunner {

    private final ArtistService artistService;

    public ApplicationDBInitializer(ArtistService artistService) {
        this.artistService = artistService;
    }


    @Override
    public void run(String... args) throws Exception {
        artistService.initArtists();
    }
}
